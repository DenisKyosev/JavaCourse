package com.sirma.itt.javacourse.exceptions;

import org.junit.Test;

import com.sirma.itt.javacource.exceptions.OutOfBoundsException;
import com.sirma.itt.javacource.exceptions.ZeroToHundred;

/**
 * test class for numbers between 0-100.
 * 
 * @author Fester
 */
public class ZeroToHundredTest {
	private ZeroToHundred range = new ZeroToHundred();

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
