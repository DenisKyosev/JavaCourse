package com.sirma.itt.javacourse.threads.task1;


/**
 * Run thread counter counting untill key is pressed.
 */
public final class RunStopMe {

	/**
	 * Instantiates a new run stop me.
	 */
	private RunStopMe() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		StopMe thread = new StopMe(5);
		Thread threadCounter = new Thread(thread);
		threadCounter.start();
		thread.read();
		System.out.println(Thread.activeCount());

	}

}
