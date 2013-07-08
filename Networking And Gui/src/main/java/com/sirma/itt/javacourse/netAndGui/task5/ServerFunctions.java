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
public class ServerFunctions {

	/** The thread. */
	private Thread thread;

	/** The server socket. */
	private ServerSocket server;
	/** The client socket. */
	private final ArrayList<Socket> clients = new ArrayList<Socket>();

	/**
	 * Instantiates a new server functions.
	 */
	ServerFunctions() {
		try {
			server = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close server.
	 * 
	 * @return true, if successful
	 */
	boolean closeServer() {
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
	String openConnection() {
		server = Connect.openServerSocket();
		if (server == null) {
			return "No available port in range 7000-7020.";
		} else {
			return "Server started on port: " + server.getLocalPort()
					+ "\r\nWaiting for clients\r\n";
		}
	}

	/**
	 * Accept client.
	 * 
	 * @return the string
	 */
	String acceptClient() {

		try {
			clients.add(server.accept());
		} catch (IOException e) {
		}
		thread = new Thread(new ServerClients(clients));
		thread.start();
		return "New client connected. \r\n Number of clients:" + clients.size() + "\r\n";

	}

	/**
	 * Accept client.
	 * 
	 * @param client
	 *            the client
	 * @return the string
	 */
	String acceptClient(Socket client) {
		clients.add(client);
		thread = new Thread(new ServerClients(clients));
		thread.start();
		return "New client connected. \r\n Number of clients:" + clients.size() + "\r\n";
	}
}
