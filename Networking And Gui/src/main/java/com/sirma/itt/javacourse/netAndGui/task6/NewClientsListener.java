package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving newClients events. The class that is interested in
 * processing a newClients event implements this interface, and the object created with that class
 * is registered with a component using the component's <code>addNewClientsListener</code> method.
 * When the newClients event occurs, that object's appropriate method is invoked.
 * 
 * @see NewClientsEvent
 */
public class NewClientsListener implements Runnable {

	/** The server. */
	private final ServerSocket server;

	/** The client. */
	private Socket client;

	/** The updated. */
	private boolean updated = false;

	/** The message. */
	private String message;

	/** The msg. */
	private final Messenger msg;

	/** The clients. */
	private final Mediator clients;

	/** The clients list. */
	private final List<Socket> clientsList = new ArrayList<Socket>();

	/**
	 * Instantiates a new new clients listener.
	 * 
	 * @param server
	 *            the server
	 * @param clients
	 *            the clients
	 */
	NewClientsListener(ServerSocket server, Mediator clients) {
		this.server = server;
		this.clients = clients;
		msg = new Messenger();
	}

	/**
	 * Close server.
	 */
	void closeServer() {
		for (int i = 0; i < clientsList.size(); i++) {
			try {
				clientsList.get(i).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				client = server.accept();
			} catch (IOException e) {
				try {
					throw new NoSocketException();
				} catch (NoSocketException e1) {
					e1.printStackTrace();
				}

			}
			ChannelsListener newClient = new ChannelsListener(client, clients);
			Thread thread = new Thread(newClient);
			thread.start();
			clientsList.add(client);
			msg.setServerMessage("New client connected\r\n");
		}
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
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	protected void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Invoked when update occurs.
	 * 
	 * @return true, if is updated
	 */
	protected boolean isUpdated() {
		return updated;
	}

	/**
	 * Invoked when Sets the update occurs.
	 * 
	 * @param updated
	 *            the updated
	 */
	protected void setUpdated(boolean updated) {
		this.updated = updated;
	}
}
