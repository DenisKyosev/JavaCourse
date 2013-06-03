package com.sirma.itt.javacourse.designpatterns.abstractFactory;

/**
 * A factory for creating Age objects.
 */
public class MyClassFactory {

	/**
	 * Age.
	 * 
	 * @param age
	 *            the age
	 * @return the age
	 */
	public Age age(String age) {
		if (age.length() >= 3) {
			return new AgeString();
		} else {
			return new AgeNumber();
		}
	}
}
