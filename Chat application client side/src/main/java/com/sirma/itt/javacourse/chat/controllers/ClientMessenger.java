package com.sirma.itt.javacourse.chat.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;

// TODO: Auto-generated Javadoc
/**
 * Communication class receiving and sending messages to server.
 */
public class ClientMessenger {
	/** The reader. */
	private BufferedReader reader;

	/** The writer. */
	private BufferedWriter writer;

	/**
	 * Instantiates a new client messenger.
	 * 
	 * @param client
	 *            the client
	 */
	protected ClientMessenger(Socket client) {
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream(),
					Charset.forName("UTF-8")));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),
					Charset.forName("UTF-8")));
		} catch (IOException e) {
		}
	}

	/**
	 * Send message to server. Cuts the message to 200 symbols.
	 * 
	 * @param message
	 *            the message
	 */
	public void send(String message) {
		try {
			String msg;
			if (message.length() > 200) {
				msg = message.substring(0, 200);
			} else {
				msg = message;
			}
			msg = msg.substring(0, 1).toUpperCase() + msg.substring(1);
			writer.write(msg);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
		}
	}

	/**
	 * Receive message from server.
	 * 
	 * @return the string
	 */
	protected String receive() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
