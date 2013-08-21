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
		if (msg.indexOf(" ") != -1) {
			command = msg.substring(1, msg.indexOf(" ")).trim();
			message = msg.substring(msg.indexOf(" ") + 1).trim();
		} else {
			command = msg.substring(1).trim();
		}
		if (command.equals("username") && !message.contains("[") && !message.contains("]")) {
			if (wrap.getClients().containsKey(messenger)) {

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
