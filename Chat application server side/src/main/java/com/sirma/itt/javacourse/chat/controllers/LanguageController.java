package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Language Controller.
 */
public class LanguageController {

	/** The language. */
	private static String language = "english";

	/** The lang. */
	private static Properties lang = new Properties();

	/** The msg. */
	private InterfaceUpdater msg = new InterfaceUpdater();

	/**
	 * Instantiates a new language controller.
	 */
	public LanguageController() {

	}

	/**
	 * Instantiates a new language controller.
	 * 
	 * @param msg
	 *            the msg
	 */
	public LanguageController(InterfaceUpdater msg) {
		this.msg = msg;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public static String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		LanguageController.language = language;
	}

	/**
	 * Gets the value from language properties file by given key.
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
