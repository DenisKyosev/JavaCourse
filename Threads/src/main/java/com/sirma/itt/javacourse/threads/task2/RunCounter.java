package com.sirma.itt.javacourse.threads.task2;

// TODO: Auto-generated Javadoc
/**
 * The Class RunCounter.
 */
public final class RunCounter {

	/**
	 * Instantiates a new run counter.
	 */
	private RunCounter() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Counters little = new Counters(999);
		Counters big = new Counters(999999);
		little.start();
		big.start();

		while (Thread.activeCount() > 1) {
			if (little.isInterrupted()) {
				big.interrupt();
				System.out.println(little.getCount());
				System.out.println(big.getCount());
			} else if (big.isInterrupted()) {
				little.interrupt();
				System.out.println(little.getCount());
				System.out.println(big.getCount());
			}

		}
	}

}
