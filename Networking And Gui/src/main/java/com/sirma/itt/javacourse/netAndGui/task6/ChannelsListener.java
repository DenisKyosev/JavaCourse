package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * Clients thread. New instance is made when new client is connected.
 */
public class ChannelsListener implements Runnable {

	/** The clients. */
	private static Socket client;
	private boolean update = false;

	protected boolean isUpdated() {
		return update;
	}

	protected void setUpdated(boolean update) {
		this.update = update;
	}

	/** The message. */
	private String message = "Welcome\r\n";

	/** The writer. */
	private PrintWriter writer;

	/** The reader. */
	private BufferedReader reader;
	ClientConnector newConnection;
	Mediator manager;
	ServerSocket server;
	Messenger msg;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 */
	ChannelsListener(Socket client) {
		this.client = client;
		msg = new Messenger();
		this.newConnection = new ClientConnector(client);
		this.manager = new Mediator();
	}

	boolean channelConnected() {
		message = newConnection.receive();
		int channel;
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
