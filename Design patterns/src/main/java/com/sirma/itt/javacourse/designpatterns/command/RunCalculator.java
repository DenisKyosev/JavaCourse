package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * The Class RunCalculator.
 */
public final class RunCalculator {

	/**
	 * Instantiates a new run calculator.
	 */
	private RunCalculator() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		CommandInvoker invoke = new CommandInvoker();

		System.out.println(invoke.execute("4^2"));

	}

}
