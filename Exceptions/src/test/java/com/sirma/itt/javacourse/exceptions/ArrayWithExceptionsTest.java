package com.sirma.itt.javacourse.exceptions;

import org.junit.Test;

/**
 * test class for array with exceptions.
 * 
 * @author Fester
 */
public class ArrayWithExceptionsTest {
	private final ArrayWithExceptions arr = new ArrayWithExceptions(2);

	/**
	 * testing add method exception.
	 * 
	 * @throws ArrayIsFullException
	 *             if array is full
	 * @throws ArrayIsEmptyException
	 */
	@Test(expected = ArrayIsFullException.class)
	public void testFullArray() throws ArrayIsFullException {
		arr.add(new Object());
		arr.add(new Object());
		arr.add(new Object());
	}

	/**
	 * testing printing method exception.
	 * 
	 * @throws ArrayIsEmptyException
	 *             empty exception
	 */
	@Test(expected = ArrayIsEmptyException.class)
	public void testPrintArray() throws ArrayIsEmptyException {
		arr.allElements();
	}

	/**
	 * testing remove method exception.
	 * 
	 * @throws ArrayIsEmptyException
	 *             if array is empty
	 */
	@Test(expected = ArrayIsEmptyException.class)
	public void testEmptyArray() throws ArrayIsEmptyException {
		arr.remove();
		arr.remove();
		arr.remove();
		arr.remove();
	}
}
