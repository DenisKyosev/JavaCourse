package com.sirma.itt.javacourse.chat.serverfunctions;

import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandParser.
 */
public class CommandParser {

	/** The wrap. */
	private final Wrapper wrap;

	/** The command. */
	private String command;

	/** The message. */
	private String message;

	/** The messenger. */
	private final ServerMessenger messenger;

	/**
	 * Instantiates a new command parser.
	 * 
	 * @param wrap
	 *            the wrapper
	 * @param msg
	 *            the server messenger
	 */
	public CommandParser(Wrapper wrap, ServerMessenger msg) {
		this.messenger = msg;
		this.wrap = wrap;
	}

	/**
	 * Parses the command.
	 * 
	 * @param msg
	 *            the message
	 */
	protected void parseCmd(String msg) {
		command = msg.substring(1, msg.indexOf(" "));
		message = msg.substring(msg.indexOf(" ") + 1);
		/*
		 * if (command.equals("username") && !message.equals("") && message.contains("[") &&
		 * message.contains("]")) { if (wrap.getClients().containsValue(message)) {
		 * wrap.getClients().put(messenger, message); if
		 * (wrap.getMsg().getComponentsFlags("new user")) {
		 * wrap.getMsg().setTextToBeUpdated("new user", "::" + message); } else {
		 * wrap.getMsg().setTextToBeUpdated("new user", message); } } }
		 */
	}

	/**
	 * Gets the command.
	 * 
	 * @return the command
	 */
	protected String getCommand() {
		return command;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}

}
