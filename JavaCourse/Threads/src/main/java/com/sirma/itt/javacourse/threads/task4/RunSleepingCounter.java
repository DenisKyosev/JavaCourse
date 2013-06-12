package com.sirma.itt.javacourse.threads.task4;

/**
 * The Class RunSleepingCounter.
 */
public final class RunSleepingCounter {

	/**
	 * Instantiates a new run sleeping counter.
	 */
	private RunSleepingCounter() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		SleepingCounter little = new SleepingCounter(15);
		SleepingCounter big = new SleepingCounter(9);
		Thread littleNumberThread = new Thread(little);
		Thread bigNumberThread = new Thread(big);
		littleNumberThread.start();
		bigNumberThread.start();
	}
}
