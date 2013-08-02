package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class InterfaceUpdater {
	private final Map<String, Boolean> componentsFlags = new HashMap<String, Boolean>();
	private final Map<String, String> componentsUpdateText = new HashMap<String, String>();
	String lang;

	public InterfaceUpdater() {
		getLanguage();
	}

	public void newComponent(String component) {
		componentsFlags.put(component, false);
		componentsUpdateText.put(component, "");
	}

	public String getUpdatedText(String component) {
		componentsFlags.put(component, false);
		return componentsUpdateText.get(component);
	}

	public boolean hasUpdate(String component) {
		if (componentsFlags.containsKey(component) && componentsFlags.get(component)) {
			return true;
		} else {
			return false;
		}
	}

	public void setTextToBeUpdated(String component, String newText) {
		if (componentsFlags.containsKey(component)) {
			if (componentsFlags.get(component)) {
				componentsUpdateText.put(component, componentsUpdateText.get(component) + newText
						+ "\r\n");
			} else {
				componentsUpdateText.put(component, newText + "\r\n");
				componentsFlags.put(component, true);
			}
		}
	}

	public String getText(String key) {
		Properties languageFile = new Properties();
		try {
			languageFile.load(new FileInputStream(lang + ".properties"));
			return languageFile.getProperty(key);
		} catch (FileNotFoundException e) {
			setTextToBeUpdated("Main area", "Error loading language.");
		} catch (IOException e) {
			setTextToBeUpdated("Main area", "Error loading language.");
		}
		return "";
	}

	private void getLanguage() {
		Properties configFile = new Properties();
		try {
			configFile.load(new FileInputStream("config.properties"));
			lang = configFile.getProperty("lastUsedLanguage");
		} catch (FileNotFoundException e) {
			setTextToBeUpdated("Main area", "Error loading configuration file.");
		} catch (IOException e) {
			setTextToBeUpdated("Main area", "Error loading configuration file.");
		}
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
		Properties configFile = new Properties();
		configFile.setProperty("lastUsedLanguage", lang);
		try {
			configFile.store(new FileOutputStream("config.properties"), null);
		} catch (FileNotFoundException e) {
			setTextToBeUpdated("Main area", "Error saving configuration file.");
		} catch (IOException e) {
			setTextToBeUpdated("Main area", "Error saving configuration file.");
		}
	}

}
