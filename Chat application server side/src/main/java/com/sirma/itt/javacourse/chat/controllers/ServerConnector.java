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

	Wrapper wrap;

	public ServerConnector(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Open server socket on port range 7000-7020.
	 * 
	 * @return the server socket
	 */
	public void openServerSocket() {
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
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("configFileError"));
			error = false;
		}

		int minPort = Integer.parseInt(config.getProperty("minPort"));
		int maxPort = Integer.parseInt(config.getProperty("maxPort"));
		try {
			for (int i = minPort; i <= maxPort; i++) {
				try {
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("serverStartedSuccess") + i);
					wrap.setServer(new ServerSocket(i));
					break;
				} catch (IOException ex) {
					continue;
				}
			}
		} catch (NumberFormatException e) {
			wrap.getMsg().setTextToBeUpdated("Main area", "configPropertiesError");
		}
	}

}
