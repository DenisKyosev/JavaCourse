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
		 * for (int i = 0; i < 200; i++) { try { Thread.sleep(100); } catch (InterruptedException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } Wrapper wrap = new Wrapper();
		 * wrap.getConnector().connect("77.78.14.79", 7010, "fester" + Double.toString(Math.random()
		 * * 20).substring(0, 7)); wrap.getMessenger().send("hello" + i); try {
		 * wrap.getClient().close(); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */

		// @SuppressWarnings("unused")
		ClientWindow client = new ClientWindow();
		// client.getWrap().getConnector().connect("localhost", 7000, "fester");
		/*
		 * for (int i = 0; i < 500; i++) { try { Thread.sleep(100); } catch (InterruptedException e)
		 * { e.printStackTrace(); } client.getWrap() .getMessenger() .send(
		 * " ar adaw d aw dawd awd awd awd awd awd awd awdawdawdwqr adaw d aw dawd awd awd awd awd awd awd awdawdaw dawd awd awd awd awd awd awd awdawdaw dawaw"
		 * ); }
		 */

	}
}
