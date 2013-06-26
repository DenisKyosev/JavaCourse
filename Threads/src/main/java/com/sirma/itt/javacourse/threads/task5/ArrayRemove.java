package com.sirma.itt.javacourse.threads.task5;

/**
 * thread removing element from the list(MyLock). If the pool is empty it waits for the other thread
 * to add an element.
 */
public class ArrayRemove extends MyLock implements Runnable {

	/**
	 * Removes an element.
	 */
	public void remove() {

		synchronized (getLock()) {

			if (MyLock.getIterator() == 0) {
				System.out.println("waiting to add");
				getLock().notifyAll();
				try {
					getLock().wait();
				} catch (InterruptedException e) {

				}
			}
			getArray()[getIterator()] = null;
			setIterator(getIterator() - 1);
			System.out.println("removed");
			getLock().notifyAll();
		}
	}

	/**
	 * run the thread.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			remove();
		}
	}
}
