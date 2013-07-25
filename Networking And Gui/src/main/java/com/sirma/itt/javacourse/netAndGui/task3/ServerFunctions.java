package com.sirma.itt.javacourse.netAndGui.task3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * Server Functions.
 */
public class ServerFunctions {

	/** The messenger. */
	private final Messenger msg;
	/** The server. */
	private ServerSocket server = null;

	/**
	 * Instantiates a new server on port 7000-7020.
	 * 
	 * @param msg
	 *            the messenger
	 */
	ServerFunctions(Messenger msg) {
		this.msg = msg;
		server = Connect.openServerSocket();
	}

	/**
	 * Check if server is started.
	 * 
	 * @return true, if started
	 */
	boolean serverStarted() {
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
	 * Send message to client.
	 * 
	 * @param client
	 *            the client
	 * @return the string
	 */
	boolean sendMessage(Socket client) {
		String message = "";
		try {
			client = server.accept();
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			message = "Hello " + Calendar.getInstance().getTime();
			writer.println(message);
			writer.println();
			writer.flush();
			msg.setServerTextArea("Client connected. \r\nSent message:" + message + "\r\n");
			return true;
		} catch (IOException e) {
			msg.setServerTextArea("System error");
			return false;
		}
	}
}
