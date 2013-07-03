package com.sirma.itt.javacourse.netAndGui.task4;

import java.io.IOException;
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
	private String message;

	/** The writer. */
	private PrintWriter writer;

	/**
	 * Instantiates a new clients control class.
	 * 
	 * @param clients
	 *            the clients
	 */
	ServerClients(ArrayList<Socket> clients) {
		ServerClients.clients = clients;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		int size = clients.size();
		for (int i = 0; i < size; i++) {
			try {
				writer = new PrintWriter(new OutputStreamWriter(clients.get(i).getOutputStream()));
			} catch (IOException e) {
			}
			if (i == size - 1) {
				message = "You're client number " + (i + 1);
			} else {
				message = "Client number " + size + " connected";
			}
			writer.println(message);
			writer.println();
			writer.flush();
		}
	}
}
