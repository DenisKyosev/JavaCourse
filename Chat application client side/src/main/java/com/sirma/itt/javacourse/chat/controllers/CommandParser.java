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
	CommandParser(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Parses the command.
	 * 
	 * @param msg
	 *            the command
	 */
	protected void parseCommand(String msg) {
		try {
			command = msg.substring(1, msg.indexOf(" "));
			property = msg.substring(msg.indexOf(" ") + 1);
			if ("connected".equals(command)) {
				if (wrap.getMsg().hasUpdate("newUser")) {
					wrap.getMsg().setTextToBeUpdated("newUser", "::" + property);
				} else {
					wrap.getMsg().setTextToBeUpdated("newUser", property);
				}
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("userConnected") + property);

			} else if ("disconnected".equals(command)) {
				wrap.getMsg().setTextToBeUpdated("userLeft", property);
				wrap.getMsg().setTextToBeUpdated("Main area",
						property + " " + wrap.getLang().getValue("userDisconnected"));

			} else if ("usersList".equals(command)) {
				wrap.getMsg().setTextToBeUpdated("Users newUser", property);
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
