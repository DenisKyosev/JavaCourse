package com.sirma.itt.javacourse.threads.task4;

/**
 * thread counting to a max number. if there is another counter thread waits after each counted
 * number.
 */
public class SleepingCounter implements Runnable {

	/** The max. */
	private final long max;

	/** The count. */
	private long count = 0;

	/** The lock. */
	private static Object lock = new Object();

	/**
	 * Instantiates a new sleeping counter.
	 * 
	 * @param max
	 *            the max
	 */
	public SleepingCounter(long max) {
		this.max = max;
	}

	/**
	 * Count from 0 to max. if there is another counter thread waits after each counted number.
	 */
	public void count() {
		while (count < max) {
			count++;
			System.out.println(Thread.currentThread().getName() + ":" + count);
			synchronized (lock) {
				lock.notifyAll();
				if (Thread.activeCount() == 3) {
					try {
						lock.wait();
					} catch (InterruptedException e) {

					}
				}
			}
		}
		synchronized (lock) {
			lock.notifyAll();
		}
		return;
	}

	/**
	 * counting from 0 to max. if there is another counter thread waits after each counted number.
	 */
	public void run() {
		count();
	}
}
