package com.sirma.itt.javacourse.designpatterns.command;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * Search for propriate command using the factory and executing it.
 */
public class CommandInvoker {
	private final Scanner scanner = new Scanner(System.in);

	/**
	 * Instantiates a new command invoker.
	 */
	CommandInvoker() {

		while (true) {
			System.out.println(execute(scanner.next()));
		}
	}

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
