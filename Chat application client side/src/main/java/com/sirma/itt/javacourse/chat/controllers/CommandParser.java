package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandParser.
 */
public class CommandParser {

	/** The self executed. */
	List<String> selfExecuted = new ArrayList<>();
	/** The wrap. */
	private final Wrapper wrap;

	/**
	 * Instantiates a new command parser.
	 * 
	 * @param wrap
	 *            the wrap
	 */
	CommandParser(Wrapper wrap) {
		this.wrap = wrap;
		selfExecuted.add("help");
		selfExecuted.add("disconnect");
		selfExecuted.add("exit");
		selfExecuted.add("quit");
	}

	/**
	 * Gets the self executed.
	 * 
	 * @return the self executed
	 */
	public List<String> getSelfExecuted() {
		return selfExecuted;
	}

	/**
	 * Sets the self executed.
	 * 
	 * @param selfExecuted
	 *            the new self executed
	 */
	public void setSelfExecuted(List<String> selfExecuted) {
		this.selfExecuted = selfExecuted;
	}

	/** The command. */
	private String command = "";

	/** The property. */
	private String property = "";

	/**
	 * Execute message as command.
	 * 
	 * @param message
	 *            the message
	 */
	public void execute(String message) {
		splitMessage(message);

		switch (command) {
			case "usernameChange":
				usernameChange();
				break;
			case "usernameUnavailable":
				usernameUnavailable();
				break;
			case "connected":
				connected();
				break;
			case "serverClosed":
				serverClosed();
				break;
			case "incognito":
				incognito();
				break;
			case "userDisconnected":
				userDisconnected();
				break;
			case "usersList":
				buildUsersList();
				break;
			case "info":
				infoCommand();
				break;

			case "help":
				help();
				break;
			case "disconnect":
				userDisconnected();
				break;
			case "exit":
				exitCommand();
				break;
			case "quit":
				quitCommand();
				break;

			default:
				invalidCommand();
				break;
		}
	}

	/**
	 * Split message into command and property.
	 * 
	 * @param message
	 *            the message
	 */
	public void splitMessage(String message) {
		if (message.indexOf(" ") != -1) {
			command = message.substring(1, message.indexOf(" ")).trim();
			property = message.substring(message.indexOf(" ") + 1).trim();
		} else {
			command = message.substring(1).trim();
		}

	}

	/**
	 * Quit command. Disconnect with quit message.
	 */
	private void quitCommand() {
		wrap.getMessenger().send("Disconnecting: " + property);
		if (wrap.getClient() != null) {
			try {
				wrap.getClient().close();
				wrap.setClient(null);
			} catch (IOException e1) {
			}
		}

	}

	/**
	 * Exit command.Close window and disconnect.
	 */
	private void exitCommand() {
		if (wrap.getClient() != null) {
			try {
				wrap.getClient().close();
				wrap.setClient(null);
			} catch (IOException e1) {
			}
		}
		System.exit(0);
	}

	/**
	 * Info command. Show server info.
	 */
	private void infoCommand() {
		StringBuilder info = new StringBuilder();
		info.append(property);
		info.append("::Address: ");
		info.append(wrap.getClient().getRemoteSocketAddress());
		String[] result = info.toString().split("::");
		for (int i = 0; i < result.length; i++) {
			wrap.getMsg().setTextToBeUpdated("Main area", result[i]);
		}

	}

	/**
	 * Receive online users list command /usersList.
	 */
	private void buildUsersList() {
		wrap.getMsg().setTextToBeUpdated("newUser", property);
		wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("connectionSuccess"));
	}

	/**
	 * Gets the command.
	 * 
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * Gets the property.
	 * 
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Help command - /help.
	 * 
	 * @return help
	 */
	public String helpWindowInfo() {
		StringBuilder result = new StringBuilder();
		result.append(wrap.getLang().getValue("help"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("helpCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("usernameCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("disconnectCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("incognitoCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("infoCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("exitCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("quitCommand"));
		result.append("\r\n");
		return result.toString();
	}

	/**
	 * Help command - /help.
	 */
	private void help() {
		StringBuilder result = new StringBuilder();
		result.append(wrap.getLang().getValue("help"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("helpCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("usernameCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("disconnectCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("incognitoCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("infoCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("exitCommand"));
		result.append("\r\n");
		result.append(wrap.getLang().getValue("quitCommand"));
		result.append("\r\n");
		wrap.getMsg().setTextToBeUpdated("Main area", result.toString());
	}

	/**
	 * User disconnected command received - /disconnect.Disconnects the client socket from the
	 * server if the username is client's username, else removes the user from users list.
	 */
	private void userDisconnected() {
		if (!wrap.getUsername().equals(property)) {
			wrap.getMsg().setTextToBeUpdated("userLeft", property);
			wrap.getMsg().setTextToBeUpdated("Main area",
					property + " " + wrap.getLang().getValue("userDisconnected"));
		} else {
			wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("disconnected"));
			try {
				wrap.getClient().close();
			} catch (IOException e) {
			}
			wrap.setClient(null);
		}
	}

	/**
	 * Invalid command.
	 */
	private void invalidCommand() {
		wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("invalidCommand"));
	}

	/**
	 * Incognito command received - /incognito. Sets client in incognito mode.
	 */
	private void incognito() {
		if (!wrap.getUsername().equals(property)) {
			wrap.getMsg().setTextToBeUpdated("userLeft", property);
			wrap.getMsg().setTextToBeUpdated("Main area",
					property + " " + wrap.getLang().getValue("userDisconnected"));
		}
	}

	/**
	 * Server closed command received - /serverClosed. Disconnects client and sets socket to null.
	 */
	private void serverClosed() {
		try {
			wrap.getClient().close();
		} catch (IOException e) {
		}
		wrap.setClient(null);
	}

	/**
	 * Connected command received - /connected. When new client connects. Adds the new user to the
	 * users list.
	 */
	private void connected() {
		if (wrap.getMsg().hasUpdate("newUser")) {
			wrap.getMsg().setTextToBeUpdated("newUser", "::" + property);
		} else {
			wrap.getMsg().setTextToBeUpdated("newUser", property);
		}
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("userConnected") + property);
	}

	/**
	 * Username unavailable command received - /usernameUnavailable.
	 */
	private void usernameUnavailable() {
		if (wrap.getClient() != null) {
			try {
				wrap.getClient().close();
			} catch (IOException e) {
			}
			wrap.setClient(null);
		}
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("usernameUnavailable"));
	}

	/**
	 * Username change command received - /username olduser-newuser. Updates the users list.
	 */
	private void usernameChange() {
		String oldUser = property.split("-")[0].trim();
		String newUser = property.split("-")[1].trim();
		wrap.getMsg().setTextToBeUpdated("userLeft", oldUser);
		wrap.getMsg().setTextToBeUpdated("newUser", newUser);
		wrap.getMsg().setTextToBeUpdated("Main area",
				oldUser + " " + wrap.getLang().getValue("usernameChange") + newUser);
		if (oldUser.equals(wrap.getUsername())) {
			wrap.setUsername(newUser);
		}
	}
}
