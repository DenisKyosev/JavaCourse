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
	private final Socket client;

	/**
	 * Instantiates a new client functions.
	 */
	ClientFunctions() {
		client = Connect.openSocket();
	}

	/**
	 * Client connected.
	 * 
	 * @return the string
	 */
	String clientConnected() {
		if (getClient() == null) {
			return "No server running on port in range 7000-7020.";
		} else {
			return getMessage() + "\r\nConnection terminated";

		}
	}

	/**
	 * Gets message from server.
	 * 
	 * @return the message
	 */
	String getMessage() {
		String result = "Client connected to server on port "
				+ Integer.toString(getClient().getPort()) + "\r\n";

		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
			message = stream.readLine();
			result += message + "\r\n";
			getClient().close();

		} catch (IOException e) {

			result += "Error while receiving message";
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Socket getClient() {
		return client;
	}
}
