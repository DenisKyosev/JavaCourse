package com.sirma.itt.javacourse.chat.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerMessenger {
	/** The reader. */
	private BufferedReader reader;

	/** The writer. */
	private BufferedWriter writer;
	private ObjectOutputStream objectWriter;

	/**
	 * Instantiates a new client connector.
	 * 
	 * @param client
	 *            the client
	 */
	public ServerMessenger(Socket client) {
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));
			objectWriter = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
		}
	}

	/**
	 * Send.
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
	 * Receive.
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

	public String[] receiveCommand() {
		String[] cmd = new String[2];
		String message = receive();
		cmd[0] = message;
		message = receive();
		cmd[1] = message;
		return cmd;
	}

	/**
	 * Gets the reader.
	 * 
	 * @return the reader
	 */
	protected BufferedReader getReader() {
		return reader;
	}

	/**
	 * Sets the reader.
	 * 
	 * @param reader
	 *            the new reader
	 */
	protected void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	/**
	 * Gets the writer.
	 * 
	 * @return the writer
	 */
	protected BufferedWriter getWriter() {
		return writer;
	}

	/**
	 * Sets the writer.
	 * 
	 * @param writer
	 *            the new writer
	 */
	protected void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}
}
