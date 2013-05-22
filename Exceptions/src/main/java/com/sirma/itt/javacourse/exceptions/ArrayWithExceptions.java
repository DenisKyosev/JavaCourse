package com.sirma.itt.javacourse.exceptions;

/**
 * add,remove,print objects array with exceptions.
 */
public class ArrayWithExceptions {

	private Object[] array;

	/** The iterator. */
	private int iterator = 0;

	/**
	 * The Constructor.
	 * @param length
	 *            the length
	 */
	public ArrayWithExceptions(final int length) {
		array = new Object[length];
	}

	/**
	 * Adds object.
	 * @param object
	 *            the object
	 * @throws ArrayIsFullException
	 *             the array is full
	 */
	public final void add(final Object object) throws ArrayIsFullException {
		if (iterator == array.length - 1) {
			throw new ArrayIsFullException("The array is full");
		}
		array[iterator] = object;
		iterator++;
	}

	/**
	 * Removes the last added element.
	 * @throws ArrayIsEmptyException
	 *             the array is empty
	 */
	public final void remove() throws ArrayIsEmptyException {
		if (iterator == 0) {
			throw new ArrayIsEmptyException();
		}
		array[iterator] = null;
		iterator--;

	}

	/**
	 * Prints all elements.
	 * @return string with all elements
	 *             empty array exception
	 */
	public final String allElements() {

		String result = "";
		for (int i = 0; i < iterator; i++) {
			result += array[i] + " ";
		}
		return result;
	}

	/**
	 * Prints all elements.
	 * @throws ArrayIsEmptyException
	 */
	public final void printAllElements() {

		System.out.println(allElements());

	}

}
