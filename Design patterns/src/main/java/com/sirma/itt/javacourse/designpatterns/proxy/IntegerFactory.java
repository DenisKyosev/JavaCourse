package com.sirma.itt.javacourse.designpatterns.proxy;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Integer objects.
 */
public class IntegerFactory {

	/**
	 * Instantiates a new integer factory.
	 */
	public IntegerFactory() {

	}

	/**
	 * Creates a new Integer object.
	 * 
	 * @return the integer proxy
	 */
	IntegerProxy createInstance() {
		return new IntegerProxy();
	}
}
