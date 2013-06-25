package com.sirma.itt.javacourse.netAndGui.task4;

// TODO: Auto-generated Javadoc
/**
 * The Class RunClient.
 */
public final class RunClient {

	/**
	 * Instantiates a new client.
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
		try {
			@SuppressWarnings("unused")
			Client client = new Client();
		} catch (NoSocketException e) {
			e.printStackTrace();
		}

	}

}
