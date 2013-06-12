package com.sirma.itt.javacourse.threads.task1;

import java.io.InputStream;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * Counting numbers thread untill key is pressed or max is reached.
 */
public class StopMe implements Runnable {

	/** The counter. */
	private int counter = 0;

	/** input flag. */
	private boolean hasInput = false;

	/** The max number. */
	private final int max;

	/** The scanner. */
	private Scanner sc = new Scanner(System.in);

	/**
	 * Instantiates a new stop me.
	 * 
	 * @param max
	 *            the max
	 */
	StopMe(int max) {
		this.max = max;
	}

	/**
	 * Read input from another input stream.
	 * 
	 * @param input
	 *            the input
	 */
	void read(InputStream input) {
		sc = new Scanner(input);
		read();
	}

	/**
	 * Read input from console and interrupt.
	 */
	public void read() {
		sc.next();
		hasInput = true;
		System.out.println(getCounter());
		sc.close();
	}

	/**
	 * counting until there's input or max is reached.
	 */
	public void run() {
		while (!hasInput) {
			counter++;
			if (Thread.currentThread().isInterrupted() || counter >= max) {
				hasInput = true;
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

	/**
	 * Gets the counter.
	 * 
	 * @return the counter
	 */
	protected long getCounter() {
		return counter;

	}

}
