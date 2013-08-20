package com.sirma.itt.javacourse.chat.controllers;

import java.net.Socket;

import com.sirma.itt.javacourse.chat.clientfunctions.Logger;

// TODO: Auto-generated Javadoc
/**
 * Connecting the client to the server.
 */
public class ClientConnector {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The command parser. */
	private CommandParser cmdParser;

	/**
	 * Instantiates a new client connector.
	 * 
	 * @param wrap
	 *            the wrapper
	 */
	ClientConnector(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * Connect client to server on specified host/port.
	 * 
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @return true, if successful
	 */
	public boolean openSocket(String host, int port) {
		try {
			wrap.setClient(new Socket(host, port));
			wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("clientStarted"));
			wrap.setMessenger(new ClientMessenger(wrap.getClient()));
			cmdParser = new CommandParser(wrap);
			return true;
		} catch (Exception e) {
			wrap.getMsg()
					.setTextToBeUpdated("Main area", wrap.getLang().getValue("connectionFail"));
			return false;
		}
	}

	/**
	 * Check username length and sends the username.
	 * 
	 * @param username
	 *            the username
	 * @return true, if successful
	 */
	public boolean checkAndSendUsername(String username) {

		if (username.length() > 13) {
			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("usernameTooLong"));
			return false;
		} else {
			wrap.getMessenger().send("/username " + username);
			return true;
		}
	}

	/**
	 * Receive username check response.
	 * 
	 * @param username
	 *            the username
	 * @return true, if successful
	 */
	public boolean receiveUsernameResponse(String username) {
		try {
			cmdParser.parseCommand(wrap.getMessenger().receive());
			if (cmdParser.getCommand().contains("Unavailable")) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("usernameUnavailable"));
				wrap.getClient().close();
				wrap.setClient(null);
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("disconnected"));
				return false;
			} else {
				wrap.setUsername(username);
				wrap.setLog(new Logger(wrap));
				wrap.getMsg().setTextToBeUpdated("newUser", cmdParser.getMessage());
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("connectionSuccess"));

				new Thread(new MessageListener(wrap)).start();
				return true;
			}

		} catch (Exception e) {
			wrap.getMsg()
					.setTextToBeUpdated("Main area", wrap.getLang().getValue("connectionFail"));
			return false;
		}
	}

	/**
	 * Connect, send username and receive response.
	 * 
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @param username
	 *            the username
	 * @return true, if successful
	 */
	public boolean connect(String host, int port, String username) {
		return openSocket(host, port) && checkAndSendUsername(username)
				&& receiveUsernameResponse(username);
	}
}
