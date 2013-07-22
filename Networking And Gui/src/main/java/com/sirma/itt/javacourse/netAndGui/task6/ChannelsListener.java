package com.sirma.itt.javacourse.netAndGui.task6;

import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * channels thread. New instance is made when new client is connected to channel.
 * 
 * @see ChannelsEvent
 */
public class ChannelsListener implements Runnable {

	/** The update flag. */
	private boolean update = false;

	/**
	 * Invoked when update occurs.
	 * 
	 * @return true, if checks if is updated
	 */
	protected boolean isUpdated() {
		return update;
	}

	/**
	 * Invoked when update occurs.
	 * 
	 * @param update
	 *            the update
	 */
	protected void setUpdated(boolean update) {
		this.update = update;
	}

	/** The message. */
	private String message = "Welcome\r\n";

	/** The new connection. */
	private final ClientConnector newConnection;

	/** The manager. */
	private final Mediator manager;

	/** The messenger. */
	private final Messenger msg;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param client
	 *            the client
	 * @param clients
	 *            the clients
	 */
	ChannelsListener(Socket client, Mediator clients) {
		this.manager = clients;
		msg = new Messenger();
		this.newConnection = new ClientConnector(client);
	}

	/**
	 * Client connected to channel.
	 * 
	 * @return true, if successful
	 */
	boolean channelConnected() {
		message = newConnection.receive();
		int channel = 0;
		try {
			channel = Integer.parseInt(message);
			manager.newUser(newConnection, channel);
			msg.setServerMessage("Client connected to channel:" + channel + "\r\n");
			return true;
		} catch (NumberFormatException e) {
			msg.setServerMessage("Wrong channel\r\n");
			newConnection.send("Wrong channel\r\n");
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			channelConnected();
		}
	}
}
