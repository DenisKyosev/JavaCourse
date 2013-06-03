package com.sirma.itt.javacourse.exceptions.zeroToHundred;

import org.junit.Test;

import com.sirma.itt.javacourse.exceptions.arrayExceptions.OutOfBoundsException;

/**
 * test class for numbers between 0-100.
 * 
 * @author Fester
 */
public class ZeroToHundredTest {
	private final ZeroToHundred range = new ZeroToHundred();

	/**
	 * testing numbers between 0-100 reader method exception.
	 * 
	 * @throws OutOfBoundsException
	 *             if array is full
	 */
	@Test(expected = OutOfBoundsException.class)
	public void testFullArray() throws OutOfBoundsException {
		range.read(111);
	}
}
