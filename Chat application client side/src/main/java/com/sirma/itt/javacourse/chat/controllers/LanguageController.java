package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Language Controller.
 */
public class LanguageController {

	/** The language. */
	private String language = "english";
	private final Properties configFile = new Properties();
	/** The language properties files. */
	private final Properties lang = new Properties();

	/** The interface updater. */
	private final InterfaceUpdater msg;

	/**
	 * Instantiates a new language controller.
	 * 
	 * @param msg
	 *            the interface updater
	 */
	LanguageController(InterfaceUpdater msg) {
		this.msg = msg;
		getLastUsedLanguage();
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the last used language.
	 */
	private void getLastUsedLanguage() {
		try {
			FileInputStream stream = new FileInputStream("resources/config.properties");
			configFile.load(stream);
			language = configFile.getProperty("lastUsedLanguage");
		} catch (FileNotFoundException e) {
			msg.setTextToBeUpdated("Main area", "Error loading configuration file.");
		} catch (IOException e) {
			msg.setTextToBeUpdated("Main area", "Error loading configuration file.");
		}
	}

	/**
	 * Sets the current language and saves it to the configuration file for later use.
	 * 
	 * @param lang
	 *            the new language
	 */
	public void setLanguage(String lang) {
		this.language = lang;
		Properties configFile = new Properties();
		configFile.setProperty("lastUsedLanguage", lang);
		try {
			configFile.store(new FileOutputStream("config.properties"), null);
		} catch (FileNotFoundException e) {
			msg.setTextToBeUpdated("Main area", "Error saving configuration file.");
		} catch (IOException e) {
			msg.setTextToBeUpdated("Main area", "Error saving configuration file.");
		}
	}

	/**
	 * Gets the value on current language.
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 */
	public String getValue(String key) {
		try {
			lang.load(new FileInputStream(language + ".properties"));
			return lang.getProperty(key);
		} catch (FileNotFoundException e) {
			msg.setTextToBeUpdated("Main area", "Error loading language.");
		} catch (IOException e) {
			msg.setTextToBeUpdated("Main area", "Error loading language.");
		}
		return "";
	}
}
