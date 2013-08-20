package com.sirma.itt.javacourse.chat.serverfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
public class Settings {

	/**
	 * Instantiates a new settings.
	 */
	public Settings() {
		File file = new File("resources");
		if (!file.exists()) {
			file.mkdir();
		} else {
			file = new File(file + "/config.properties");
			if (!file.exists()) {
				try {
					file.createNewFile();
					config.load(new FileInputStream(file));
					config.setProperty("host", "localhost");
					config.setProperty("minPort", "7000");
					config.setProperty("maxPort", "7020");
					config.store(new FileOutputStream(file), null);
				} catch (Exception e) {
				}
			}
		}
	}

	/** The config. */
	private final Properties config = new Properties();

	/**
	 * Save settings.
	 * 
	 * @param host
	 *            the host
	 * @param minPort
	 *            the min port
	 * @param maxPort
	 *            the max port
	 * @return true, if successful
	 */
	public boolean saveSettings(String host, String minPort, String maxPort) {
		try {
			config.load(new FileInputStream("resources/config.properties"));
		} catch (Exception e) {
		}
		config.setProperty("host", host);
		config.setProperty("minPort", minPort);
		config.setProperty("maxPort", maxPort);
		try {
			config.store(new FileWriter("resources/config.properties"), null);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Gets the last used settings.
	 * 
	 * @param key
	 *            the key
	 * @return the settings
	 */
	public String getSettings(String key) {
		try {
			config.load(new FileInputStream("resources/config.properties"));
		} catch (Exception e) {
		}
		return config.getProperty(key);
	}
}
