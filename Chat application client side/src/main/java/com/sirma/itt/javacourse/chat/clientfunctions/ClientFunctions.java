package com.sirma.itt.javacourse.chat.clientfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ClientFunctions {
	public String getSettings(String key) {
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			return "Error";
		} catch (IOException e) {
			return "Error";
		}
		return config.getProperty(key);
	}

	public boolean saveSettings(String host, String port, String username) {
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		config.setProperty("host", host);
		config.setProperty("port", port);
		config.setProperty("lastUsedUsername", username);
		try {
			config.store(new FileWriter("config.properties"), null);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
