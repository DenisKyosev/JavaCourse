package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientFunctions.
 */
public class ClientFunctions {
	/** The client socket. */
	private Socket client;

	/** The message. */
	private String message;

	/** The txt area. */
	private final JTextArea txtArea;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param txtArea
	 *            the txt area
	 */
	ClientFunctions(JTextArea txtArea) {
		this.txtArea = txtArea;
		client = new Socket();
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 */
	void openConnection() throws NoSocketException {
		client = Connect.openSocket();
		message = "No server running on port in range 7000-7020.";
		if (client == null) {
			txtArea.append(message);
		} else {
			message = "Client connected to server on port " + Integer.toString(client.getPort())
					+ "\r\n";
			getMessageFromServer();
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

		txtArea.append(message);
		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while ((message = stream.readLine()) != null) {
				txtArea.append(message + "\r\n");
				if ("Server closed".equals(message)) {
					throw new NoSocketException("boom");
				}
			}
			client.close();
		} catch (IOException e) {
			throw new NoSocketException();
		}
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}
}
