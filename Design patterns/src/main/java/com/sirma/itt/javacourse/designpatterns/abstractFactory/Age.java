package com.sirma.itt.javacourse.designpatterns.abstractFactory;

/**
 * The Class Age.
 */
public class Age {

	/** The age in string format. */
	private String age;

	/** The age in number format. */
	private int ageNumber;

	/**
	 * Gets the age number.
	 * 
	 * @return the age number
	 */
	public int getAgeNumber() {
		return ageNumber;
	}

	/**
	 * Sets the age number.
	 * 
	 * @param ageNumber
	 *            the new age number
	 */
	public void setAgeNumber(int ageNumber) {
		this.ageNumber = ageNumber;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age in string
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets the age in string.
	 * 
	 * @param age
	 *            the new age in string
	 */
	public void setAge(String age) {
		this.age = age;
	}
}
