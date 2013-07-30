package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LanguageController {
	private static String language = "english";
	static Properties lang = new Properties();;
	InterfaceUpdater msg = new InterfaceUpdater();

	public LanguageController() {

	}

	public LanguageController(InterfaceUpdater msg) {
		this.msg = msg;
	}

	public static String getLanguage() {
		return language;
	}

	public static void setLanguage(String language) {
		LanguageController.language = language;
	}

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
