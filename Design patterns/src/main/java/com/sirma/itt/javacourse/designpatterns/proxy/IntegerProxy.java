package com.sirma.itt.javacourse.designpatterns.proxy;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerProxy.
 */
public class IntegerProxy implements Num {

	/** The integer. */
	private Integer integer = new Integer();

	/**
	 * get integer.
	 * 
	 * @return integer
	 */
	public int getRealNumber() {
		return integer.getRealNumber();
	}

	/**
	 * Gets the integer.
	 * 
	 * @return the integer
	 */
	public Integer getInteger() {
		return integer;
	}

	/**
	 * Sets the integer object.
	 * 
	 * @param number
	 *            the new integer object
	 */
	public void setInteger(Integer number) {
		this.integer = number;
	}

}
