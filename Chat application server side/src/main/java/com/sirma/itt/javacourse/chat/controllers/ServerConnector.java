package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Connect.
 */
public final class ServerConnector {

	InterfaceUpdater msg = new InterfaceUpdater();
	LanguageController lang;

	public ServerConnector(InterfaceUpdater msg) {
		this.msg = msg;
		this.lang = new LanguageController(msg);
	}

	/**
	 * Open server socket on port range 7000-7020.
	 * 
	 * @return the server socket
	 */
	public ServerSocket openServerSocket() {
		boolean error = false;
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("config.properties"));
		} catch (IOException e1) {
			error = true;
			config.setProperty("minPort", "7000");
			config.setProperty("maxPort", "7020");
			try {
				config.store(new FileOutputStream("config.properties"), null);
			} catch (FileNotFoundException e) {
				error = true;
			} catch (IOException e) {
				error = true;
			}
		}

		if (error) {
			msg.setTextToBeUpdated("Main area", lang.getValue("configFileError"));
			error = false;
		}

		int minPort = Integer.parseInt(config.getProperty("minPort"));
		int maxPort = Integer.parseInt(config.getProperty("maxPort"));
		try {
			for (int i = minPort; i <= maxPort; i++) {
				try {
					msg.setTextToBeUpdated("Main area", lang.getValue("serverStartedSuccess") + i);
					return new ServerSocket(i);
				} catch (IOException ex) {
					continue;
				}
			}
		} catch (NumberFormatException e) {
			msg.setTextToBeUpdated("Main area", "configPropertiesError");
		}
		return null;
	}

	public int closeServer() {

		return 0;
	}
}
