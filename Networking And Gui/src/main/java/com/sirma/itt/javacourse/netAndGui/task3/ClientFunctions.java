package com.sirma.itt.javacourse.netAndGui.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * Client Functions.
 */
public class ClientFunctions {

	/** The message. */
	private String message;

	/** The client. */
	private Socket client = null;

	/** The messanger. */
	private final Messenger msg;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param msg
	 *            the messemger
	 */
	ClientFunctions(Messenger msg) {
		this.msg = msg;
		client = Connect.openSocket();
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
	 * Client connected.
	 * 
	 * @return the string
	 */
	protected boolean clientConnected() {
		if (client == null) {
			msg.setClientTextArea("No server running on port in range 7000-7020.");
			return false;
		} else {
			getMessage();
			msg.setClientTextArea("Connection terminated");
			return true;

		}
	}

	/**
	 * Gets message from server.
	 * 
	 * @return the message
	 */
	protected boolean getMessage() {
		msg.setClientTextArea("Client connected to server on port "
				+ Integer.toString(client.getPort()) + "\r\n");

		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			message = stream.readLine();
			msg.setClientTextArea(message + "\r\n");
			client.close();

		} catch (IOException e) {
			msg.setClientTextArea("Error while receiving message\r\n");
			return false;
		}
		return true;
	}
}
