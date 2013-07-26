package com.sirma.itt.javacourse.netAndGui.task5;

// TODO: Auto-generated Javadoc
/**
 * UI - Functions connection (controller).
 */
public class Messenger {

	/** The client text area. */
	private String clientTextArea = "";

	/** The client flag. */
	private boolean clientTextAreaFlag = false;

	/** The server text area. */
	private String serverTextArea = "";

	/** The server flag. */
	private boolean serverFlag = false;

	/**
	 * Gets the string to be appended to the client's text area.
	 * 
	 * @return the string to be appended to the client's text area
	 */
	protected String getClientTextArea() {
		clientTextAreaFlag = false;
		return clientTextArea;
	}

	/**
	 * Sets the string to be appended to the client's text area.
	 * 
	 * @param clientTextArea
	 *            the string to be appended to the client's text area
	 */
	protected void setClientTextArea(String clientTextArea) {
		if (clientTextAreaFlag) {
			this.clientTextArea += clientTextArea;
		} else {
			clientTextAreaFlag = true;
			this.clientTextArea = clientTextArea;
		}

	}

	/**
	 * Client text area changed flag up.
	 * 
	 * @return true, if changed
	 */
	protected boolean clientTextAreaFlagUp() {
		return clientTextAreaFlag;
	}

	/**
	 * Gets the new string to be appended to the server's text area.
	 * 
	 * @return the new string to be appended to the server's text area
	 */
	protected String getServerTextArea() {
		serverFlag = false;
		return serverTextArea;
	}

	/**
	 * Sets the new string to be appended to the server's text area.
	 * 
	 * @param serverTextArea
	 *            the new string to be appended to the server's text area
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
	 * Server text area changed flag up.
	 * 
	 * @return true, if changed
	 */
	protected boolean serverTextAreaChanged() {
		return serverFlag;
	}

}
