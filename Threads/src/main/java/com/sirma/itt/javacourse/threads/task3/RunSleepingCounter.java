package com.sirma.itt.javacourse.threads.task3;

// TODO: Auto-generated Javadoc
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
	 */
	public static void main(String[] args) {
		SleepingCounter littleNumber = new SleepingCounter(5, 500);
		SleepingCounter bigNumber = new SleepingCounter(9, 1000);
		littleNumber.start();
		bigNumber.start();

		while (Thread.activeCount() > 1) {
			System.out.println(littleNumber.getCount());
			System.out.println(bigNumber.getCount());
		}
	}
}
