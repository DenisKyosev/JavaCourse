package com.sirma.itt.javacourse.chat.controllers;

import java.io.FileInputStream;
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
	 * 
	 * @return the settings
	 */
	protected boolean getSettings() {

		try {
			config.load(new FileInputStream("resources/config.properties"));
			return true;
		} catch (IOException e1) {
			config.setProperty("minPort", "7000");
			config.setProperty("maxPort", "7020");
			config.setProperty("host", "localhost");
			try {
				config.store(new FileOutputStream("resources/config.properties"), null);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * Open server socket on port range from configuration file.
	 * 
	 * @return true, if successful
	 */
	public boolean openServerSocket() {
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
					return true;
				} catch (Exception ex) {
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("portInUse") + i);
				}
			}
		}
		return false;

	}

	/**
	 * Start server.
	 * 
	 * @return true, if successful
	 */
	public boolean connect() {
		if (!getSettings()) {
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("configFileError"));
		}
		openServerSocket();
		return wrap.getServer() != null;
	}
}
