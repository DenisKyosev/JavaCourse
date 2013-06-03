package com.sirma.itt.javacourse.designpatterns.abstractFactory;

/**
 * Sets the age in number format.
 */
public class AgeNumber extends Age {

	/**
	 * What is it.
	 * 
	 * @param age
	 *            the age in int
	 */
	void whatIsIt(String age) {
		setAgeNumber(Integer.parseInt(age));
	}
}
