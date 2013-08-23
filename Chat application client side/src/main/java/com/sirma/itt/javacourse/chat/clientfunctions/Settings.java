package com.sirma.itt.javacourse.chat.clientfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * Settings reader and saver.
 */
public class Settings {

	/** The config. */
	private final Properties config = new Properties();

	/**
	 * Instantiates a settings. Creates settings file if not exist.
	 */
	public Settings() {
		File file = new File("resources");
		if (!file.exists()) {
			file.mkdir();
		}
		file = new File(file + "/config.properties");
		if (!file.exists()) {
			try {
				file.createNewFile();
				config.load(new FileInputStream(file));
				config.setProperty("host", "localhost");
				config.setProperty("port", "7000");
				config.setProperty("lastUsedUsername", "yourName");
				config.setProperty("lastUsedLanguage", "english");
				config.store(new FileOutputStream(file), null);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Returns setting by given key.
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

	/**
	 * Save settings.
	 * 
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @param username
	 *            the username
	 * @return true, if successful
	 */
	public boolean saveSettings(String host, String port, String username) {
		config.setProperty("host", host);
		config.setProperty("port", port);
		config.setProperty("lastUsedUsername", username);
		try {
			config.store(new FileOutputStream("resources/config.properties"), null);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
