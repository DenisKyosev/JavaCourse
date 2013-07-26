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
	private final Messenger msg;

	/** The closed. */
	private boolean closed = false;

	/** The connector. */
	private ClientConnector connector;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param msg
	 *            the msg
	 */
	ClientFunctions(Messenger msg) {
		this.msg = msg;
		client = new Socket();
	}

	/**
	 * Set message to send.
	 * 
	 * @param msg
	 *            the message
	 */
	protected void send(String msg) {
		connector.send(msg);
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             if there is no server running exception
	 */
	protected void openConnection() throws NoSocketException {
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

	/**
	 * Gets the connector.
	 * 
	 * @return the connector
	 */
	protected ClientConnector getConnector() {
		return connector;
	}
}
