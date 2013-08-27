package com.sirma.itt.javacourse.chat.gui;

import com.sirma.itt.javacourse.chat.controllers.Wrapper;

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

		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ClientWindow client = new ClientWindow();
			Wrapper wrap = new Wrapper();
			wrap.getConnector().connect("localhost", 7000,
					"fe" + Double.toString(Math.random() * 20).substring(0, 9));
			for (int j = 0; j < 5; j++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wrap.getMessenger().send(Double.toString(Math.random() * 20).substring(0, 9));
			}

		}

		// @SuppressWarnings("unused")
		// ClientWindow client = new ClientWindow();
		// client.getWrap().getConnector().connect("localhost", 7000, "fester");

		/*
		 * for (int i = 0; i < 500; i++) { try { Thread.sleep(100); } catch (InterruptedException e)
		 * { e.printStackTrace(); } client.getWrap() .getMessenger() .send(
		 * " ar adaw d aw dawd awd awd awd awd awd awd awdawdawdwqr adaw d aw dawd awd awd awd awd awd awd awdawdaw dawd awd awd awd awd awd awd awdawdaw dawaw"
		 * ); }
		 */

	}
}
