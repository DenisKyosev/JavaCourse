package com.sirma.itt.javacourse.chat.serverfunctions;

import java.net.Socket;
import java.util.Iterator;

import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * New users listener thread.
 */
public class NewUserThread implements Runnable {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The username. */
	private String username;
	/** The client. */
	private final Socket client;

	/** The messenger. */
	private ServerMessenger messenger;

	/**
	 * Instantiates a new new user thread.
	 * 
	 * @param wrap
	 *            the wrap
	 * @param client
	 *            the client
	 */
	public NewUserThread(Wrapper wrap, Socket client) {
		this.wrap = wrap;
		this.client = client;
	}

	/**
	 * Check received username.
	 * 
	 * @param client
	 *            the client
	 * @return true, if successful
	 */
	protected boolean checkUsername(Socket client) {
		if (client != null) {
			messenger = new ServerMessenger(client);
			CommandParser parser = new CommandParser(wrap, messenger);

			try {
				parser.splitCommand(messenger.receive());
				username = parser.getMessage();
				if (wrap.getClients().contains(username) || username.contains("[")
						|| username.contains("]")) {
					messenger.send("/UsernameUnavailable " + username);
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("usernameUnavailable") + username);
					return false;
				} else {

					if (wrap.getMsg().getComponentsFlags("new user")) {
						wrap.getMsg().setTextToBeUpdated("new user", "::" + username);
					} else {
						wrap.getMsg().setTextToBeUpdated("new user", username);
					}

					return true;
				}
			} catch (Exception e) {

			}
		}
		return false;
	}

	/**
	 * Notifies all clients that new user logged in.
	 * 
	 * @param username
	 *            the username
	 */
	private void newUserLogged(String username) {
		Iterator<ServerMessenger> clients = wrap.getClients().keySet().iterator();
		while (clients.hasNext()) {
			ServerMessenger msg = clients.next();
			msg.send("/connected " + username);
		}
	}

	/**
	 * Builds the users list.
	 * 
	 * @return the string
	 */
	private String buildUsersList() {
		StringBuilder list = new StringBuilder();
		Iterator<String> usernames = wrap.getClients().values().iterator();
		while (usernames.hasNext()) {
			list.append(usernames.next());
			if (usernames.hasNext()) {
				list.append("::");
			}
		}
		return list.toString();
	}

	/**
	 * Start message listener. Sends connected clients list to the new user.
	 */
	private void startListener() {
		wrap.getClients().put(messenger, username);
		new Thread(new MessageListener(messenger, wrap)).start();
		messenger.send("/usersList " + buildUsersList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		if (checkUsername(client)) {
			newUserLogged(username);
			startListener();
		}
	}
}
