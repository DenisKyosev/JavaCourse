package com.sirma.itt.javacourse.chat.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Server - client messenger.
 */
public class ServerMessenger {
	/** The reader. */
	private BufferedReader reader;

	/** The writer. */
	private BufferedWriter writer;

	/** The client. */
	private Socket client;

	/**
	 * Instantiates a new server - client messenger.
	 * 
	 * @param client
	 *            the client
	 */
	public ServerMessenger(Socket client) {
		try {
			this.client = client;
			reader = new BufferedReader(new InputStreamReader(client.getInputStream(),
					Charset.forName("UTF-8")));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),
					Charset.forName("UTF-8")));
			writer.flush();
		} catch (IOException e) {
		}
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Socket getClient() {
		return client;
	}

	/**
	 * Send message to client.
	 * 
	 * @param message
	 *            the message
	 */
	public void send(String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
		}
	}

	/**
	 * Receive message from client. Blocks until message is received or connection is lost.
	 * 
	 * @return the string
	 */
	public String receive() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Time builder.
	 * 
	 * @return the string
	 */
	public String timeBuilder() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

		return format.format(date);
	}
}
