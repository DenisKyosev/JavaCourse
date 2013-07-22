package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;
import com.sirma.itt.javacourse.netAndGui.task5.Originator;

// TODO: Auto-generated Javadoc
/**
 * Client window functions.
 */
public class ClientFunctions implements Runnable {
	/** The client socket. */
	private Socket client;

	/** The out. */
	private PrintWriter out;
	/** The message. */
	private String message = "";
	Messenger msg;

	/** The send. */
	private final String send = "";

	/** The memento. */
	private Originator memento;

	/** The current. */
	private final int current = 0;
	ClientConnector connector;

	void send(String msg) {
		connector.send(msg);
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	void openConnection() throws IOException {
		client = Connect.openSocket();
		if (client == null) {
			message = "No server running on port in range 7000-7020.";
		} else {
			message += "Client connected to server on port: " + Integer.toString(client.getPort())
					+ "\r\n";
		}
		msg.setClientMessage(message);
		connector = new ClientConnector(client);
	}

	@Override
	public void run() {
		client = new Socket();
		msg = new Messenger();
		try {
			openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			message = connector.receive();
			msg.setClientMessage(message + "\r\n");
		}
	}
}
