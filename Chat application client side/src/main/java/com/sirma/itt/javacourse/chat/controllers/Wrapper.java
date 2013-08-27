package com.sirma.itt.javacourse.chat.controllers;

import java.net.Socket;

import com.sirma.itt.javacourse.chat.clientfunctions.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Wrapper.
 */
public class Wrapper {

	/** The connector. */
	private final ClientConnector connector;

	/** The interface updater. */
	private final InterfaceUpdater msg;

	/** The messenger. */
	private ClientMessenger messenger;

	/** The command parser. */
	private final CommandParser cmdParser;

	/** The language controller. */
	private final LanguageController lang;

	/** The client. */
	private Socket client;

	/** The logger class. */
	private Logger log;

	/** The current username. */
	private String username = "";

	/**
	 * Gets the command parser.
	 * 
	 * @return the command parser
	 */
	public CommandParser getCmdParser() {
		return cmdParser;
	}

	/**
	 * Gets the current username.
	 * 
	 * @return the current username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the current username.
	 * 
	 * @param username
	 *            the current username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Instantiates a new wrapper.
	 */
	public Wrapper() {
		this.msg = new InterfaceUpdater();
		this.lang = new LanguageController(msg);
		this.log = new Logger(msg, lang);
		log.createLogFile(username);
		this.connector = new ClientConnector(this);
		this.cmdParser = new CommandParser(this);
		client = null;
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
	 * Gets the connector.
	 * 
	 * @return the connector
	 */
	public ClientConnector getConnector() {
		return connector;
	}

	/**
	 * Gets the msg.
	 * 
	 * @return the msg
	 */
	public InterfaceUpdater getMsg() {
		return msg;
	}

	/**
	 * Gets the messenger.
	 * 
	 * @return the messenger
	 */
	public ClientMessenger getMessenger() {
		return messenger;
	}

	/**
	 * Sets the messenger.
	 * 
	 * @param messenger
	 *            the new messenger
	 */
	public void setMessenger(ClientMessenger messenger) {
		this.messenger = messenger;
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
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Socket getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 * 
	 * @param client
	 *            the new client
	 */
	public void setClient(Socket client) {
		this.client = client;
	}

	/**
	 * Sets the logger.
	 * 
	 * @param log
	 *            the new logger
	 */
	public void setLog(Logger log) {
		this.log = log;
	}
}
