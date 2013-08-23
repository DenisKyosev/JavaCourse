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
	 * Info command builder.
	 * 
	 * @return the string
	 */
	private String infoCommand() {
		StringBuilder build = new StringBuilder();
		build.append("Server started on: " + wrap.getServerStartDate() + "\r\n");
		build.append("Port: " + wrap.getServer().getLocalPort() + "\r\n");
		build.append("Host: " + wrap.getServer().getLocalSocketAddress() + "\r\n");
		build.append("Online users count: " + wrap.getClients().size());

		return build.toString();
	}

	/**
	 * Splits the command in property and command part.
	 * 
	 * @param msg
	 *            the msg
	 */
	protected void splitCommand(String msg) {
		if (msg.indexOf(" ") != -1) {
			command = msg.substring(1, msg.indexOf(" ")).trim();
			message = msg.substring(msg.indexOf(" ") + 1).trim();
		} else {
			command = msg.substring(1).trim();
		}
	}

	/**
	 * Parses the command.
	 * 
	 * @param msg
	 *            the message
	 */
	protected void parseCmd(String msg) {
		splitCommand(msg);
		if ("username".equals(command) && !message.contains("[") && !message.contains("]")) {
			if (wrap.getClients().containsKey(messenger)
					&& !wrap.getClients().containsValue(message)) {

				String oldUser = wrap.getClients().get(messenger);
				wrap.getClients().remove(messenger);
				wrap.getClients().put(messenger, message);

				wrap.getMsg().setTextToBeUpdated("Main area",
						oldUser + " " + wrap.getLang().getValue("changeUsername") + message);
				message = oldUser + "-" + message;
				if (wrap.getMsg().getComponentsFlags("usernameChange")) {
					wrap.getMsg().setTextToBeUpdated("usernameChange", "::" + message);
				} else {
					wrap.getMsg().setTextToBeUpdated("usernameChange", message);
				}
				messenger.sendMessageToAll("/usernameChange " + message, wrap.getClientsIterator());

			} else {
				messenger.send("/usernameUnavailable");
			}
		} else if ("disconnect".equals(command)) {
			String username = wrap.getClients().get(messenger);
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("userDisconnected") + username);
			wrap.getClients().remove(messenger);
			if (wrap.getMsg().getComponentsFlags("logout user")) {
				wrap.getMsg().setTextToBeUpdated("logout user", "::" + username);
			} else {
				wrap.getMsg().setTextToBeUpdated("logout user", username);
			}
			messenger.sendMessageToAll("/disconnect " + username, wrap.getClientsIterator());
		} else if ("incognito".equals(command)) {
			String username = wrap.getClients().get(messenger);
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("userWentIncognito") + username);
			if (wrap.getMsg().getComponentsFlags("usernameChange")) {
				wrap.getMsg().setTextToBeUpdated("usernameChange",
						"::" + username + "-" + username + "[inv]");
			} else {
				wrap.getMsg().setTextToBeUpdated("usernameChange",
						username + "-" + username + "[inv]");
			}
			messenger.sendMessageToAll("/incognito " + username, wrap.getClientsIterator());
		} else if ("info".equals(command)) {
			messenger.send(infoCommand());
		}

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
