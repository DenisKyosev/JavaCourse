package com.sirma.itt.javacourse.threads.task3;

/**
 * The Class SleepingCounter.
 */
public class WaitingCounter extends Thread {

	/** The stopped. */
	private boolean stopped = false;

	/**
	 * Checks if is stopped.
	 * 
	 * @return true, if is stopped
	 */
	public boolean isStopped() {
		return stopped;
	}

	/**
	 * Sets the stopped.
	 * 
	 * @param stopped
	 *            the new stopped
	 */
	public void setStoped(boolean stopped) {
		this.stopped = stopped;
	}

	/** The max. */
	private final long max;

	/** The count. */
	private long count = 0;

	private final int sleepTime;

	/**
	 * Instantiates a new sleeping counter.
	 * 
	 * @param max
	 *            the max
	 * @param sleepTime
	 *            sleeping time
	 */
	public WaitingCounter(long max, int sleepTime) {
		this.max = max;
		this.sleepTime = sleepTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (count < max && Thread.activeCount() > 2) {
			count++;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
			}
		}
		this.interrupt();

	}

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public long getCount() {

		return count;
	}

}
