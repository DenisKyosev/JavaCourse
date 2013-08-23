package com.sirma.itt.javacourse.chat.controllers;

// TODO: Auto-generated Javadoc
/**
 * Parses received commands from the server.
 */
public class CommandParser {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The command. */
	private String command;

	/** The message. */
	private String property;

	/**
	 * Instantiates a new command parser.
	 * 
	 * @param wrap
	 *            the wrapper
	 */
	public CommandParser(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Parses the command.
	 * 
	 * @param msg
	 *            the command
	 */
	public void parseCommand(String msg) {
		try {
			if (msg.indexOf(" ") != -1) {
				command = msg.substring(1, msg.indexOf(" ")).trim();
				property = msg.substring(msg.indexOf(" ") + 1).trim();
			} else {
				command = msg.substring(1).trim();
			}

			if ("connected".equals(command)) {
				if (wrap.getMsg().hasUpdate("newUser")) {
					wrap.getMsg().setTextToBeUpdated("newUser", "::" + property);
				} else {
					wrap.getMsg().setTextToBeUpdated("newUser", property);
				}
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("userConnected") + property);

			} else if ("disconnect".equals(command)) {
				if (wrap.getUsername().equals(property)) {
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("disconnected"));
					wrap.getClient().close();
					wrap.setClient(null);
				} else {
					wrap.getMsg().setTextToBeUpdated("userLeft", property);
					wrap.getMsg().setTextToBeUpdated("Main area",
							property + " " + wrap.getLang().getValue("userDisconnected"));
				}

			} else if ("usernameChange".equals(command)) {
				String oldUser = property.split("-")[0].trim();
				String newUser = property.split("-")[1].trim();
				wrap.getMsg().setTextToBeUpdated("userLeft", oldUser);
				wrap.getMsg().setTextToBeUpdated("newUser", newUser);
				wrap.getMsg().setTextToBeUpdated("Main area",
						oldUser + " " + wrap.getLang().getValue("usernameChange") + newUser);
				if (oldUser.equals(wrap.getUsername())) {
					wrap.setUsername(newUser);
				}

			} else if ("usernameUnavailable".equals(command)) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("usernameUnavailable"));

			} else if ("serverClosed".equals(command)) {
				wrap.getClient().close();
				wrap.setClient(null);

			} else if ("incognito".equals(command)) {
				String newUser = "";
				wrap.getMsg().setTextToBeUpdated("userLeft", property);
				wrap.getMsg().setTextToBeUpdated("Main area",
						property + " " + wrap.getLang().getValue("userDisconnected") + newUser);

			} else if ("help".equals(command)) {

				String result = wrap.getLang().getValue("help") + "\r\n";
				result += wrap.getLang().getValue("helpCommand") + "\r\n";
				result += wrap.getLang().getValue("usernameCommand") + "\r\n";
				result += wrap.getLang().getValue("disconnectCommand") + "\r\n";
				result += wrap.getLang().getValue("incognitoCommand") + "\r\n";
				result += wrap.getLang().getValue("infoCommand") + "\r\n";
				wrap.getMsg().setTextToBeUpdated("Main area", result);

			}
		} catch (Exception e) {
			wrap.setClient(null);
		}
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
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return property;
	}

}
