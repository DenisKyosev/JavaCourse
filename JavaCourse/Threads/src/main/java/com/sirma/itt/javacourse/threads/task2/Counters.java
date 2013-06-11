package com.sirma.itt.javacourse.threads.task2;

// TODO: Auto-generated Javadoc
/**
 * Couting thread.
 */
public class Counters extends Thread {

	/** The stoped. */
	private boolean stoped = false;

	/**
	 * Checks if is stoped.
	 * 
	 * @return true, if is stoped
	 */
	public boolean isStoped() {
		return stoped;
	}

	/**
	 * Sets the stoped.
	 * 
	 * @param stoped
	 *            the new stoped
	 */
	public void setStoped(boolean stoped) {
		this.stoped = stoped;
	}

	/** The max. */
	private final long max;

	/** The count. */
	private long count = 0;

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 * 
	 * @param count
	 *            the new count
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * Instantiates a new counters.
	 * 
	 * @param max
	 *            the max
	 */
	public Counters(long max) {
		this.max = max;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (count < max && !this.isInterrupted()) {
			count++;
		}
		this.interrupt();
	}

}
