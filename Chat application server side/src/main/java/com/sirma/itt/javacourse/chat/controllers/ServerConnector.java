package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * Server starter.
 */
public final class ServerConnector {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The error flag. */
	private boolean error = false;

	/** The configuration file. */
	private final Properties config = new Properties();

	/**
	 * Instantiates a new server starter.
	 * 
	 * @param wrap
	 *            the wrap
	 */
	public ServerConnector(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Gets the last used settings.
	 */
	private void getSettings() {

		try {
			config.load(new FileInputStream("resources/config.properties"));
		} catch (IOException e1) {
			error = true;
			config.setProperty("minPort", "7000");
			config.setProperty("maxPort", "7020");
			config.setProperty("host", "localhost");
			try {
				config.store(new FileOutputStream("resources/config.properties"), null);
			} catch (FileNotFoundException e) {
				error = true;
			} catch (IOException e) {
				error = true;
			}
		}
	}

	/**
	 * Open server socket on port range from configuration file.
	 */
	public void openServerSocket() {
		int minPort;
		int maxPort;
		try {
			minPort = Integer.parseInt(config.getProperty("minPort"));
			maxPort = Integer.parseInt(config.getProperty("maxPort"));
		} catch (NumberFormatException e) {
			wrap.getMsg().setTextToBeUpdated("Main area", "configPropertiesError");
			minPort = 7000;
			maxPort = 7020;
		}
		for (int i = minPort; i <= maxPort; i++) {
			if (wrap.getServer() == null) {
				try {
					wrap.setServer(new ServerSocket(i));
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("serverStartedSuccess") + i);
				} catch (Exception ex) {
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("portInUse") + i);
				}
			}
		}

	}

	/**
	 * Start server.
	 * 
	 * @return true, if successful
	 */
	public boolean connect() {
		getSettings();

		if (error) {
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("configFileError"));
			error = false;
		}
		openServerSocket();
		return wrap.getServer() != null;
	}
}
