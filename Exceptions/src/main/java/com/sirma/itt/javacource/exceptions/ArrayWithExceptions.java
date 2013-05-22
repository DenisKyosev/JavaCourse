package com.sirma.itt.javacource.exceptions;

/**
 * add,remove,print objects array with exceptions.
 */
public class ArrayWithExceptions {

	/** The obj array. */
	private Object[] array;

	/** The iterator. */
	private int iterator = 0;

	/**
	 * The Constructor.
	 * 
	 * @param length
	 *            the length
	 */
	public ArrayWithExceptions(int length) {
		array = new Object[length];
	}

	/**
	 * Adds object.
	 * 
	 * @param object
	 *            the object
	 * @throws ArrayIsFullException
	 *             the array is full
	 */
	public void add(Object object) throws ArrayIsFullException {
		if (iterator == array.length - 1) {
			throw new ArrayIsFullException("The array is full");
		}
		array[iterator] = object;
		iterator++;
	}

	/**
	 * Removes the last added element.
	 * 
	 * @throws ArrayIsEmptyException
	 *             the array is empty
	 */
	public void remove() throws ArrayIsEmptyException {
		if (iterator == 0) {
			throw new ArrayIsEmptyException();
		}
		array[iterator] = null;
		iterator--;

	}

	/**
	 * Prints all elements.
	 * 
	 * @return string with all elements
	 * @throws ArrayIsEmptyException
	 *             empty array exception
	 */
	public String allElements() throws ArrayIsEmptyException {
		if (iterator == 0)
			throw new ArrayIsEmptyException();

		String result = "";
		for (int i = 0; i < iterator; i++) {
			result += array[i] + " ";
		}
		return result;
	}

	/**
	 * Prints all elements.
	 * 
	 * @throws ArrayIsEmptyException
	 */
	public void printAllElements() {
		try {
			System.out.println(allElements());
		} catch (ArrayIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
