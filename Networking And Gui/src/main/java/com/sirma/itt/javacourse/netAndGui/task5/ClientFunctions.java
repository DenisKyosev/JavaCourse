package com.sirma.itt.javacourse.netAndGui.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

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
	private String message;

	/** The flag. */
	private boolean flag = false;

	/** The memento. */
	private final Originator memento;

	/** The send string. */
	private String sendString = "";

	/** The messenger. */
	private final Messenger msg;

	/** The saved states. */
	private final List<Memento> savedStates;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param msg
	 *            the messenger
	 */
	protected ClientFunctions(Messenger msg) {
		client = new Socket();
		this.msg = msg;
		memento = new Originator();
		savedStates = new ArrayList<Memento>();
	}

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param msg
	 *            the messenger
	 * @param savedStates
	 *            the saved states
	 * @param memento
	 *            the memento
	 */
	ClientFunctions(Messenger msg, List<Memento> savedStates, Originator memento) {
		client = new Socket();
		this.msg = msg;
		this.savedStates = savedStates;
		this.memento = memento;
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void openConnection() throws NoSocketException, IOException {
		client = Connect.openSocket();
		if (client == null) {
			msg.setClientTextArea("No server running on port in range 7000-7020.");
		}
		try {
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			msg.setClientTextArea("Error in connection");
		}

		if (client == null) {
			msg.setClientTextArea(message);
		} else {
			message = "Client connected to server on port " + Integer.toString(client.getPort())
					+ "\r\n";
			msg.setClientTextArea(message);

		}

	}

	/**
	 * Send message.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception Signals that an I/O exception has occurred.
	 */
	protected void sendMessage() throws NoSocketException {
		if (!sendString.contains(".")) {
			if (flag) {
				savedStates.add(memento.saveToMemento(sendString));
				out.println(sendString);
				out.flush();
				getMessageFromServer();
				flag = false;
			}
		} else {
			try {
				client.close();
			} catch (IOException e) {
				throw new NoSocketException();
			}
		}
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	protected Socket getClient() {
		return client;
	}

	/**
	 * Gets message from server.
	 * 
	 * @throws NoSocketException
	 *             the server is closed
	 */
	protected void getMessageFromServer() throws NoSocketException {
		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			message = stream.readLine();
			msg.setClientTextArea(message + "\r\n");
		} catch (IOException e) {
			throw new NoSocketException();
		}
	}

	/**
	 * Sets the flag.
	 * 
	 * @param flag
	 *            the new flag
	 */
	protected void setFlag(boolean flag) {
		this.flag = flag;
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
	 * Sets the send.
	 * 
	 * @param sendString
	 *            the new send
	 */
	protected void setSend(String sendString) {
		this.sendString = sendString;
		flag = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sendMessage();
			} catch (NoSocketException e) {
				e.printStackTrace();
			}
		}
	}
}
