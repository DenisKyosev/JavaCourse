package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerClients.
 */
public class ServerClients implements Runnable {

	/** The clients. */
	private static Socket client;

	/** The message. */
	private String message;

	/** The writer. */
	private PrintWriter writer;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 */
	ServerClients(Socket client) {
		ServerClients.client = client;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
		}
		message = "Welcome.";
		writer.println(message);
		writer.println();
		writer.flush();
	}
}
