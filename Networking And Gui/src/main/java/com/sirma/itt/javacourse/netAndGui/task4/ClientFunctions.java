package com.sirma.itt.javacourse.netAndGui.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientFunctions.
 */
public class ClientFunctions {
	/** The client socket. */
	private Socket client;

	/** The messenger. */
	private final Messenger msg;
	/** The message. */
	private String message;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param msg
	 *            the messenger
	 * @throws NoSocketException
	 *             the no socket exception
	 */
	ClientFunctions(Messenger msg) throws NoSocketException {
		this.msg = msg;
		client = new Socket();
		openConnection();
	}

	/**
	 * Open connection.
	 * 
	 * @return true, if successful
	 * @throws NoSocketException
	 *             the no socket exception
	 */
	boolean openConnection() throws NoSocketException {
		client = Connect.openSocket();
		if (client == null) {
			msg.setClientTextArea("No server running on port in range 7000-7020.");
			return false;
		} else {
			msg.setClientTextArea("Client connected to server on port "
					+ Integer.toString(client.getPort()) + "\r\n");
			return true;
		}
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	protected Socket getClient() {
		return client;
	}

	/**
	 * Gets message from server. the client socket
	 * 
	 * @throws NoSocketException
	 *             the server is closed
	 */
	void getMessageFromServer() throws NoSocketException {
		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while ((message = stream.readLine()) != null) {
				msg.setClientTextArea(message + "\r\n");
				if ("Server closed".equals(message)) {
					throw new NoSocketException("boom");
				}
			}
			client.close();
		} catch (IOException e) {
			throw new NoSocketException();
		}
	}
}
