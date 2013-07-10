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
	private String message = "Welcome";

	/** The writer. */
	private PrintWriter writer;

	/** The reader. */
	private BufferedReader reader;

	private final JTextArea txtArea;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 */
	ServerClients(ArrayList<Socket> clients, JTextArea txtArea) {
		ServerClients.clients = clients;
		this.txtArea = txtArea;
	}

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

	protected void receiveAndRespond() throws IOException {
		reader = new BufferedReader(new InputStreamReader(clients.get(clients.size() - 1)
				.getInputStream()));
		message = reader.readLine();

		if (!".".contains(message)) {
			txtArea.append("Received message \"" + message + "\"\r\n");
			writer.println("The reverse of [" + message + "] is ["
					+ new StringBuilder(message).reverse().toString() + "]");
			writer.println();
			writer.flush();
			txtArea.append("Sent reversed message\r\n");
			message = reader.readLine();
		}
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
}
