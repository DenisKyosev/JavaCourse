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
		Counters little = new Counters(4);
		Counters big = new Counters(9);
		little.start();
		big.start();

		while (Thread.activeCount() > 1) {
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1 - " + little.getCount());
			System.out.println("Thread 2 - " + big.getCount());

		}
	}
}
