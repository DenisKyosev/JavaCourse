package com.sirma.itt.javacourse.designpatterns.command;

/**
 * Search for propriate command using the factory and executing it.
 */
public class CommandInvoker {
	private final Factory factory = new Factory();

	/**
	 * Execute.
	 * 
	 * @param input
	 *            the input
	 * @param cmd
	 *            the command
	 * @return the double result
	 */
	public double execute(String input, Calculate cmd) {
		return factory.getCommand(input).execute(input, cmd);
	}

}
