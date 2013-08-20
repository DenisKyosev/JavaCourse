package com.sirma.itt.javacourse.chat.serverfunctions;

import java.io.IOException;
import java.net.Socket;

import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Clients Accept Thread.
 */
public class ClientsAcceptThread implements Runnable {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The stop. */
	private boolean stop = false;

	/**
	 * Instantiates a new clients accept thread.
	 * 
	 * @param wrap
	 *            the wrap
	 */
	public ClientsAcceptThread(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Accept new client.
	 * 
	 * @return the socket
	 */
	private Socket acceptNewClient() {
		Socket client = null;
		try {
			client = wrap.getServer().accept();
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("newClientConnected"));
			new Thread(new NewUserThread(wrap, client)).start();
		} catch (IOException e) {
			stop = true;
		}

		return client;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!stop) {
			acceptNewClient();
		}

	}
}
