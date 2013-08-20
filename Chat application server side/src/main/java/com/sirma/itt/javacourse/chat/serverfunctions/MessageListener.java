package com.sirma.itt.javacourse.chat.serverfunctions;

import java.util.Iterator;

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
	 * User logout notifier.Sends command to all connected clients to remove the user from their
	 * lists.
	 * 
	 * @param username
	 *            the username
	 */
	private void userLogoutNotifier(String username) {
		Iterator<ServerMessenger> clients = wrap.getClients().keySet().iterator();
		while (clients.hasNext()) {
			clients.next().send("/disconnected " + username);
		}
	}

	/**
	 * Send message to all clients.
	 * 
	 * @param msg
	 *            the msg
	 */
	private void sendMessage(String msg) {
		Iterator<ServerMessenger> clients = wrap.getClients().keySet().iterator();
		while (clients.hasNext()) {
			ServerMessenger messenger = clients.next();

			messenger.send(buildMessage(msg, messenger));
		}
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
	 * User logged out case.Removes client from clients list. Sends username to client notifier.
	 */
	private void userLoggedOut() {
		String username = wrap.getClients().get(msg);
		wrap.getClients().remove(msg);
		userLogoutNotifier(username);
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("userDisconnected") + username);
		if (wrap.getMsg().getComponentsFlags("logout user")) {
			wrap.getMsg().setTextToBeUpdated("logout user", "::" + username);
		} else {
			wrap.getMsg().setTextToBeUpdated("logout user", username);
		}
		stop = true;
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
					userLoggedOut();
				} else if (message.startsWith("/")) {
					commandReceived();
				} else {
					wrap.getMsg().setTextToBeUpdated("Main area", buildMessage(message, msg));
					sendMessage(message);
				}
			} catch (Exception e) {
				stop = true;
			}
		}
	}
}
