package com.sirma.itt.javacourse.netAndGui.task3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

/**
 * Server Functions.
 */
public class ServerFunctions {

	/** The server. */
	private ServerSocket server = null;

	/**
	 * Instantiates a new server on port 7000-7020.
	 */
	ServerFunctions() {
		server = Connect.openServerSocket();
	}

	/**
	 * Check if server is started.
	 * 
	 * @return started or no available port
	 */
	String serverStarted() {
		if (server == null) {
			return "No available port in range 7000-7020.";
		} else {
			return "Server started on port: " + server.getLocalPort()
					+ "\r\nWaiting for clients\r\n";
		}
	}

	/**
	 * Send message to client.
	 * 
	 * @param client
	 *            the client
	 * @return the string
	 */
	String sendMessage(Socket client) {
		String message = "";
		try {
			client = server.accept();
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			message = "Hello " + Calendar.getInstance().getTime();
			writer.println(message);
			writer.println();
			writer.flush();
			return "Client connected. \r\nSent message:" + message + "\r\n";
		} catch (IOException e) {
			return "System error";
		}
	}
}
