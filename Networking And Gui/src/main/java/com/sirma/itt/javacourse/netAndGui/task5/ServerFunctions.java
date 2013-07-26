package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerFunctions.
 */
public class ServerFunctions implements Runnable {

	/** The thread. */
	private Thread thread;

	/** The server socket. */
	private ServerSocket server;
	/** The client socket. */
	private final ArrayList<Socket> clients = new ArrayList<Socket>();

	/** The messenger. */
	private final Messenger msg;

	/**
	 * Instantiates a new server functions.
	 * 
	 * @param msg
	 *            the msg
	 */
	ServerFunctions(Messenger msg) {
		this.msg = msg;
		try {
			server = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the clients.
	 * 
	 * @return the clients
	 */
	protected ArrayList<Socket> getClients() {
		return clients;
	}

	/**
	 * Close server.
	 * 
	 * @return true, if successful
	 */
	protected boolean closeServer() {
		try {
			for (int j = 0; j < clients.size(); j++) {
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(clients.get(j)
						.getOutputStream()));
				writer.println("Server closed");
				writer.flush();
			}
			server.close();
			return true;
		} catch (IOException e1) {
			return false;
		}
	}

	/**
	 * Open connection.
	 * 
	 * @return the string
	 */
	protected boolean openConnection() {
		server = Connect.openServerSocket();
		if (server == null) {
			msg.setServerTextArea("No available port in range 7000-7020.");
			return false;
		} else {
			msg.setServerTextArea("Server started on port: " + server.getLocalPort()
					+ "\r\nWaiting for clients\r\n");
			return true;
		}
	}

	/**
	 * Accept client.
	 * 
	 * @return the string
	 */
	protected boolean acceptClient() {
		try {
			clients.add(server.accept());
		} catch (IOException e) {
			msg.setServerTextArea("Error while accepting client.\r\n");
			return false;
		}
		ServerClients client = new ServerClients(clients, msg);
		thread = new Thread(client);
		thread.start();
		msg.setServerTextArea("New client connected. \r\n Number of clients:" + clients.size()
				+ "\r\n");
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			acceptClient();
		}
	}
}
