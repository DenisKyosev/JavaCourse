package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import com.sirma.itt.javacourse.chat.log.Logger;
import com.sirma.itt.javacourse.chat.serverfunctions.ClientsAcceptThread;

// TODO: Auto-generated Javadoc
/**
 * The Class Wrapper.
 */
public class Wrapper {

	/** The interface updater. */
	private final InterfaceUpdater msg;

	/** The language controller. */
	private final LanguageController lang;

	/** The connector. */
	private final ServerConnector connector;

	/** The server. */
	private ServerSocket server;

	/** The logger. */
	private final Logger log;

	/** The server start date. */
	private String serverStartDate;

	/**
	 * Gets the server start date.
	 * 
	 * @return the server start date
	 */
	public String getServerStartDate() {
		return serverStartDate;
	}

	/** The clients. */
	private final Hashtable<ServerMessenger, String> clients = new Hashtable<ServerMessenger, String>();

	/** The clients iterator. */
	private Iterator<ServerMessenger> clientsIterator;

	/**
	 * Gets the clients iterator.
	 * 
	 * @return the clients iterator
	 */
	public Iterator<ServerMessenger> getClientsIterator() {
		clientsIterator = clients.keySet().iterator();
		return clientsIterator;
	}

	/**
	 * Instantiates a new wrapper.
	 */
	public Wrapper() {
		this.connector = new ServerConnector(this);
		this.msg = new InterfaceUpdater();
		this.lang = new LanguageController(msg);
		server = null;
		log = new Logger(this);

	}

	/**
	 * Gets the connected clients list.
	 * 
	 * @return the connected clients list
	 */
	public Hashtable<ServerMessenger, String> getClients() {
		return clients;
	}

	/**
	 * Gets the logger.
	 * 
	 * @return the logger
	 */
	public Logger getLog() {
		return log;
	}

	/**
	 * Start server and new clients listener thread.
	 */
	public void connect() {
		if (connector.connect()) {
			ClientsAcceptThread newClientListener = new ClientsAcceptThread(this);
			new Thread(newClientListener).start();
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			serverStartDate = format.format(date);
		} else {
			this.msg.setTextToBeUpdated("Main area", this.getLang().getValue("cantStartServer"));
		}
	}

	/**
	 * Stop server.
	 */
	public void disconnect() {
		try {
			while (getClientsIterator().hasNext()) {
				getClientsIterator().next().send("/serverClosed ");
			}
			server.close();
			server = null;
			this.getMsg().setTextToBeUpdated("Main area", this.getLang().getValue("serverStopped"));
		} catch (IOException e) {
		}
	}

	/**
	 * Gets the server.
	 * 
	 * @return the server
	 */
	public ServerSocket getServer() {
		return server;
	}

	/**
	 * Sets the server.
	 * 
	 * @param server
	 *            the new server
	 */
	protected void setServer(ServerSocket server) {
		this.server = server;
	}

	/**
	 * Gets the interface updater.
	 * 
	 * @return the interface updater
	 */
	public InterfaceUpdater getMsg() {
		return msg;
	}

	/**
	 * Gets the language controller.
	 * 
	 * @return the language controller
	 */
	public LanguageController getLang() {
		return lang;
	}

	/**
	 * Gets the server connector.
	 * 
	 * @return the server connector
	 */
	public ServerConnector getConnector() {
		return connector;
	}

}
