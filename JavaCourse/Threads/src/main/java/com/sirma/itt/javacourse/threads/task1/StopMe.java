package com.sirma.itt.javacourse.threads.task1;

import java.util.Scanner;

/**
 * Counting numbers thread untill key is pressed.
 */
public class StopMe extends Thread {

	/** The counter thread. */
	private final Thread count = new Thread();

	/** The counter. */
	private long counter = 0;

	/** input flag. */
	private boolean hasInput = false;

	/**
	 * Read.
	 */
	public void read() {
		Scanner sc = new Scanner(System.in);
		sc.next();
		hasInput = true;
		count.interrupt();
		System.out.println(getCounter());
		sc.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!hasInput) {
			setCounter(getCounter() + 1);
			if (count.isInterrupted()) {
				break;
			}
		}
	}

	/**
	 * Gets the counter.
	 * 
	 * @return the counter
	 */
	public long getCounter() {
		return counter;

	}

	/**
	 * Sets the counter.
	 * 
	 * @param counter
	 *            the new counter
	 */
	public void setCounter(long counter) {
		this.counter = counter;
	}

}
