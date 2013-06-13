package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * Search for propriate command using the factory and executing it.
 */
public class CommandInvoker {

	/** The factory. */
	private final Factory factory = new Factory();

	/**
	 * Execute.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double execute(String input) {
		return factory.getCommand(input).execute(input);
	}

}
