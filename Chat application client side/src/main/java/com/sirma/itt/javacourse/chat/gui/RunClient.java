package com.sirma.itt.javacourse.chat.gui;

// TODO: Auto-generated Javadoc
/**
 * The Class RunClient.
 */
public final class RunClient {

	/**
	 * Instantiates a new run client.
	 */
	private RunClient() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		/*
		 * for (int i = 0; i < 100; i++) { ClientWindow client = new ClientWindow();
		 * client.wrap.getConnector().openSocket("localhost", 7000, "fester" +
		 * Double.toString(Math.random() * 20).substring(0, 5));
		 * client.wrap.getMessenger().send("hello" + i); }
		 */

		@SuppressWarnings("unused")
		ClientWindow client = new ClientWindow();
	}
}
