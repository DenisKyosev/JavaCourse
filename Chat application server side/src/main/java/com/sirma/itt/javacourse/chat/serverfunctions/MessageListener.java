package com.sirma.itt.javacourse.chat.serverfunctions;

import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * Listens for messages and passes them to interested methods or classes.
 * 
 * @see MessageEvent
 */
public class MessageListener implements Runnable {

	/** The wrap. */
	private final Wrapper wrap;

	/** The server messenger. */
	private final ServerMessenger msg;

	/** The stop. */
	private boolean stop = false;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new message listener.
	 * 
	 * @param msg
	 *            the msg
	 * @param wrap
	 *            the wrap
	 */
	MessageListener(ServerMessenger msg, Wrapper wrap) {
		this.wrap = wrap;
		this.msg = msg;
	}

	/**
	 * Builds the message.
	 * 
	 * @param msg
	 *            the msg
	 * @param messenger
	 *            the messenger
	 * @return the string
	 */
	private String buildMessage(String msg, ServerMessenger messenger) {
		StringBuilder message = new StringBuilder();
		message.append("<");
		message.append(wrap.getClients().get(messenger));
		message.append(">: ");
		message.append(msg);
		return message.toString();
	}

	/**
	 * Sends received command to parser.
	 */
	private void commandReceived() {
		CommandParser cmd = new CommandParser(wrap, msg);
		cmd.parseCmd(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("userThreadStarted"));
		while (!stop) {
			try {
				message = msg.receive();
				if (message == null) {
					String username = wrap.getClients().get(msg);
					message = "/disconnect " + username;
					commandReceived();
					stop = true;
				} else if (message.startsWith("/")) {
					System.out.println(message);
					commandReceived();
				} else {
					message = buildMessage(message, msg);
					wrap.getMsg().setTextToBeUpdated("Main area", message);
					msg.sendMessageToAll(message, wrap.getClientsIterator());
				}
			} catch (Exception e) {
				stop = true;
			}
		}
	}
}
