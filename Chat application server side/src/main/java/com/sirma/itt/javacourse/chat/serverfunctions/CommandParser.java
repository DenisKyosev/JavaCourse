package com.sirma.itt.javacourse.chat.serverfunctions;

import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * Command parser server side.
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
	 * Info command message builder.
	 */
	private void infoCommand() {
		StringBuilder build = new StringBuilder();
		build.append("/info ");
		build.append("Server started on: ");
		build.append(wrap.getServerStartDate());
		build.append("::");

		build.append("Online users count: ");
		build.append(wrap.getClients().size());
		build.append("::");

		build.append("Port: ");
		build.append(wrap.getServer().getLocalPort());

		messenger.send(build.toString().trim());
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
	 * Execute a command.
	 * 
	 * @param msg
	 *            the msg
	 */
	protected void execute(String msg) {
		splitCommand(msg);
		switch (command) {
			case "username":
				checkUsername();
				break;
			case "disconnect":
				disconnectUser();
				break;
			case "incognito":
				incognito();
				break;
			case "info":
				infoCommand();
				break;

			default:
				invalidCommand();
				break;
		}
	}

	/**
	 * Invalid command.
	 */
	private void invalidCommand() {
	}

	/**
	 * Incognito command received - /incognito. Sets client in incognito mode.
	 */
	private void incognito() {
		String username = wrap.getClients().get(messenger);
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("userWentIncognito") + username);
		if (wrap.getMsg().getComponentsFlags("usernameChange")) {
			wrap.getMsg().setTextToBeUpdated("usernameChange", "::" + username + "-" + username);
		} else {
			wrap.getMsg().setTextToBeUpdated("usernameChange", username + "-" + username);
		}
		messenger.sendMessageToAll("/incognito " + username, wrap.getClientsIterator());
	}

	/**
	 * Disconnect user.
	 */
	private void disconnectUser() {
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
	}

	/**
	 * Check if username is available and does not contain forbidden characters.
	 */
	private void checkUsername() {
		if (!message.contains("[") && !message.contains("]")) {
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
