package com.sirma.itt.javacourse.threads.task5;

// TODO: Auto-generated Javadoc
/**
 * The Class MyLock making array of objects with an iterator.
 */
public class MyLock {

	/**
	 * Instantiates a new my lock.
	 */
	protected MyLock() {

	}

	/** The locking object. */
	private static Object lock = new Object();

	/** The iterator. */
	private static int iterator = 0;

	/** The array. */
	private static Object[] array = new Object[5];

	/**
	 * Gets the iterator.
	 * 
	 * @return the iterator
	 */
	public static int getIterator() {
		return iterator;
	}

	/**
	 * Sets the iterator.
	 * 
	 * @param iterator
	 *            the new iterator
	 */
	public static void setIterator(int iterator) {
		MyLock.iterator = iterator;
	}

	/**
	 * Gets the array.
	 * 
	 * @return the array
	 */
	public static Object[] getArray() {
		return array;
	}

	/**
	 * Sets the array.
	 * 
	 * @param array
	 *            the new array
	 */
	public static void setArray(Object[] array) {
		MyLock.array = array;
	}

	/**
	 * Gets the lock.
	 * 
	 * @return the lock
	 */
	public static Object getLock() {
		return lock;
	}

	/**
	 * Sets the lock.
	 * 
	 * @param lock
	 *            the new lock
	 */
	public static void setLock(Object lock) {
		MyLock.lock = lock;
	}

}
