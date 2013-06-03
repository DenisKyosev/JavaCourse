package com.sirma.itt.javacourse.exceptions.zeroToHundred;

import com.sirma.itt.javacourse.exceptions.arrayExceptions.OutOfBoundsException;

/**
 * run class for zero to hundred.
 * 
 * @author Fester
 */
public final class RunZeroToHundred {
	/**
	 * constructor.
	 */
	private RunZeroToHundred() {

	}

	private static ZeroToHundred readNumbers = new ZeroToHundred();

	/**
	 * @param args
	 *            no
	 * @throws OutOfBoundsException
	 *             if number is not in range [0-100]
	 */
	public static void main(String[] args) throws OutOfBoundsException {
		while (true) {
			System.out.println(readNumbers.read());
		}

	}

}
