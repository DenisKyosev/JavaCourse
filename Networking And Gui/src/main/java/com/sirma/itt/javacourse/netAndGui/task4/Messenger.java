package com.sirma.itt.javacourse.netAndGui.task4;

// TODO: Auto-generated Javadoc
/**
 * UI - Functions connection (controller).
 */
public class Messenger {

	/** The client text area. */
	private String clientTextArea = "";

	/** The client flag. */
	private boolean clientFlag = false;

	/** The server text area. */
	private String serverTextArea = "";

	/** The server flag. */
	private boolean serverFlag = false;

	/**
	 * Gets the client text area.
	 * 
	 * @return the client text area
	 */
	protected String getClientTextArea() {
		clientFlag = false;
		return clientTextArea;
	}

	/**
	 * Sets the client text area.
	 * 
	 * @param clientTextArea
	 *            the new client text area
	 */
	protected void setClientTextArea(String clientTextArea) {
		if (clientFlag) {
			this.clientTextArea += clientTextArea;
		} else {
			clientFlag = true;
			this.clientTextArea = clientTextArea;
		}

	}

	/**
	 * Client flag up.
	 * 
	 * @return true, if successful
	 */
	protected boolean clientFlagUp() {
		return clientFlag;
	}

	/**
	 * Gets the server text area.
	 * 
	 * @return the server text area
	 */
	protected String getServerTextArea() {
		serverFlag = false;
		return serverTextArea;
	}

	/**
	 * Sets the server text area.
	 * 
	 * @param serverTextArea
	 *            the new server text area
	 */
	protected void setServerTextArea(String serverTextArea) {
		if (serverFlag) {
			this.serverTextArea += serverTextArea;
		} else {
			serverFlag = true;
			this.serverTextArea = serverTextArea;
		}

	}

	/**
	 * Server flag up.
	 * 
	 * @return true, if flag is up
	 */
	protected boolean serverTextAreaChanged() {
		return serverFlag;
	}

}
