package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The Class Integer.
 */
public class Integer implements Num {

	/** The number. */
	private int number = 13;

	/**
	 * Gets the number.
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 * 
	 * @param number
	 *            the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * get integer.
	 * 
	 * @return integer
	 */
	public int getRealNumber() {
		return getNumber();
	}

}
