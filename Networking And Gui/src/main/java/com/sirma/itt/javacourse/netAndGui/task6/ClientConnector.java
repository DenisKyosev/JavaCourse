package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientConnector.
 */
public class ClientConnector {

	/** The reader. */
	private BufferedReader reader;

	/** The writer. */
	private BufferedWriter writer;

	/**
	 * Instantiates a new client connector.
	 * 
	 * @param client
	 *            the client
	 */
	ClientConnector(Socket client) {
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send.
	 * 
	 * @param message
	 *            the message
	 */
	protected void send(String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Receive.
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
