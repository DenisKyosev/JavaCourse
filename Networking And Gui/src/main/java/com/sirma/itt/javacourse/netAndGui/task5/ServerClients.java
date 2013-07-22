package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * Clients thread. New instance is made when new client is connected.
 */
public class ServerClients implements Runnable {

	/** The clients. */
	private static ArrayList<Socket> clients;

	/** The message. */
	private String message = "Welcome\r\n";

	/** The writer. */
	private PrintWriter writer;

	/** The reader. */
	private BufferedReader reader;

	/** The txt area. */
	private final JTextArea txtArea;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 * @param txtArea
	 *            the txt area
	 */
	ServerClients(ArrayList<Socket> clients, JTextArea txtArea) {
		ServerClients.clients = clients;
		this.txtArea = txtArea;
	}

	/**
	 * Greet client.
	 */
	protected void greetClient() {
		try {
			writer = new PrintWriter(new OutputStreamWriter(clients.get(clients.size() - 1)
					.getOutputStream()), true);

			writer.println(message);
			writer.println();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Receive and respond.
	 * 
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected String receiveAndRespond() throws IOException {
		reader = new BufferedReader(new InputStreamReader(clients.get(clients.size() - 1)
				.getInputStream()));
		message = reader.readLine();
		String result = "";
		if (!".".contains(message)) {
			result = "Received message \"" + message + "\"\r\n";
			writer.println("The reverse of [" + message + "] is ["
					+ new StringBuilder(message).reverse().toString() + "]");
			writer.println();
			writer.flush();
			result += "Sent reversed message\r\n";
		}
		txtArea.append(result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			greetClient();
			while (true) {
				receiveAndRespond();
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	protected void setMessage(String message) {
		this.message = message;
	}
}
