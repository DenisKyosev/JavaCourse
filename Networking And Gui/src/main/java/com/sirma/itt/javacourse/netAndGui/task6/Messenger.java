package com.sirma.itt.javacourse.netAndGui.task6;

// TODO: Auto-generated Javadoc
/**
 * The Class Messenger.
 */
public class Messenger {

	/** The server message. */
	private static String serverMessage = "";

	/** The update server. */
	private static boolean updateServer = false;

	/** The client message. */
	private static String clientMessage = "";

	/** The update client. */
	private static boolean updateClient = false;

	/**
	 * Gets the server message.
	 * 
	 * @return the server message
	 */
	protected String getServerMessage() {
		updateServer = false;
		return serverMessage;
	}

	/**
	 * Sets the server message.
	 * 
	 * @param serverMessage
	 *            the new server message
	 */
	protected void setServerMessage(String serverMessage) {
		updateServer = true;
		Messenger.serverMessage += serverMessage;
	}

	/**
	 * Checks if is updated server.
	 * 
	 * @return true, if is updated server
	 */
	protected boolean isUpdateServer() {
		return updateServer;
	}

	/**
	 * Gets the client message.
	 * 
	 * @return the client message
	 */
	protected String getClientMessage() {
		updateClient = false;
		return clientMessage;
	}

	/**
	 * Sets the client message.
	 * 
	 * @param clientMessage
	 *            the new client message
	 */
	protected void setClientMessage(String clientMessage) {
		updateClient = true;
		Messenger.clientMessage += clientMessage;
	}

	/**
	 * Checks if is updated client.
	 * 
	 * @return true, if is updated client
	 */
	protected boolean isUpdateClient() {
		return updateClient;
	}

}
