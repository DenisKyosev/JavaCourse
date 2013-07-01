package com.sirma.itt.javacourse.threads.task3;

// TODO: Auto-generated Javadoc
/**
 * The Class RunSleepingCounter.
 */
public final class RunWaitingCounter {

	/**
	 * Instantiates a new run sleeping counter.
	 */
	private RunWaitingCounter() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		WaitingCounter littleNumber = new WaitingCounter(5, 500);
		WaitingCounter bigNumber = new WaitingCounter(9, 1000);
		littleNumber.start();
		bigNumber.start();

		while (Thread.activeCount() > 1) {
			System.out.println(littleNumber.getCount());
			System.out.println(bigNumber.getCount());
		}
	}
}
