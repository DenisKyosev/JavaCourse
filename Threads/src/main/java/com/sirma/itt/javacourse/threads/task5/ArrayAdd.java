package com.sirma.itt.javacourse.threads.task5;

/**
 * thread adding element to the list(MyLock). If the pool is full it waits for the other thread to
 * remove an element.
 */
public class ArrayAdd extends MyLock implements Runnable {

	/**
	 * Adds the object.
	 * 
	 * @param object
	 *            the object
	 */
	public synchronized void add(final Object object) {
		synchronized (getLock()) {
			if (getIterator() == getArray().length - 1) {
				System.out.println("array full .. waiting for delete");
				getLock().notifyAll();
				try {
					getLock().wait();
				} catch (InterruptedException e) {
				}
			}
			getArray()[getIterator()] = object;
			setIterator(getIterator() + 1);

			System.out.println("added");
			getLock().notifyAll();
		}
	}

	/**
	 * run the thread.
	 */
	public void run() {
		while (true) {
			add(new Object());

		}
	}
}
