package com.sirma.itt.javacourse.netAndGui.task6;

import java.net.Socket;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * Client window functions.
 */
public class ClientFunctions implements Runnable {
	/** The client socket. */
	private Socket client;

	/** The message. */
	private String message = "";

	/** The messenger. */
	private Messenger msg;

	/** The closed. */
	private boolean closed = false;

	/** The connector. */
	private ClientConnector connector;

	/**
	 * Send.
	 * 
	 * @param msg
	 *            the msg
	 */
	void send(String msg) {
		connector.send(msg);
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             if there is no server running exception
	 */
	void openConnection() throws NoSocketException {
		client = Connect.openSocket();
		if (client == null) {
			message = "No server running on port in range 7000-7020.";
		} else {
			message += "Client connected to server on port: " + Integer.toString(client.getPort())
					+ "\r\n";
		}
		msg.setClientMessage(message);
		connector = new ClientConnector(client);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		client = new Socket();
		msg = new Messenger();
		try {
			openConnection();
		} catch (NoSocketException e) {
			e.printStackTrace();
		}
		while (!closed) {
			message = connector.receive();
			if (message == null) {
				msg.setClientMessage("Server closed");
				closed = true;
			} else {
				msg.setClientMessage(message + "\r\n");
			}
		}
	}
}
