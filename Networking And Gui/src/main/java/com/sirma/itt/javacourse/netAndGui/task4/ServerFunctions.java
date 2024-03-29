package com.sirma.itt.javacourse.netAndGui.task4;

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

	/** The msg. */
	private final Messenger msg;
	/** The server socket. */
	private ServerSocket server;
	/** The client socket. */
	private final ArrayList<Socket> clients = new ArrayList<Socket>();

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
			msg.setServerTextArea("Error starting server.\r\n");
		}
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
			msg.setServerTextArea("Something went wrong while connecting to client.\r\n");
			return false;
		}
		Thread thread = new Thread(new ServerClients(clients));
		thread.start();
		msg.setServerTextArea("New client connected. \r\n Number of clients:" + clients.size()
				+ "\r\n");
		return true;
	}

	/**
	 * Accept client.
	 * 
	 * @param client
	 *            the client
	 * @return the string
	 */
	/*
	 * String acceptClient(Socket client) { clients.add(client); Thread thread = new Thread(new
	 * ServerClients(clients)); thread.start(); return
	 * "New client connected. \r\n Number of clients:" + clients.size() + "\r\n"; }
	 */
}
