package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerClients.
 */
public class ServerClients implements Runnable {

	/** The clients. */
	private static ArrayList<Socket> clients;

	/** The message. */
	private final String message = "Welcome";

	/** The writer. */
	private PrintWriter writer;
	BufferedReader reader;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 */
	ServerClients(ArrayList<Socket> clients) {
		ServerClients.clients = clients;
	}

	void receiveMessage() {
		try {
			writer = new PrintWriter(new OutputStreamWriter(clients.get(clients.size() - 1)
					.getOutputStream()), true);
			reader = new BufferedReader(new InputStreamReader(clients.get(clients.size() - 1)
					.getInputStream()));

			writer.println(message);
			writer.println();
			writer.flush();

			String line = reader.readLine();

			while (!".".contains(line)) {
				writer.println(new StringBuilder(line).reverse().toString());
				writer.println();
				writer.flush();
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		receiveMessage();
	}
}
