package com.sirma.itt.javacourse.designpatterns.command;

import java.util.HashMap;

/**
 * The calculator command Factory.
 */
public class Factory {

	/** The map containing operations. */
	private HashMap<Character, Command> map = new HashMap<Character, Command>();

	/**
	 * Instantiates a new factory with math operations.
	 */
	public Factory() {
		map.put('+', new PlusCommand());
		map.put('-', new MinusCommand());
		map.put('/', new DivisionCommand());
		map.put('*', new MultiplyCommand());
		map.put('^', new GradationCommand());
	}

	/**
	 * Gets the command to be passed to the calculator.
	 * 
	 * @param input
	 *            the input string
	 * @return the command
	 */
	public Command getCommand(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				return map.get(input.charAt(i));
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Gets the map.
	 * 
	 * @return the map
	 */
	public HashMap<Character, Command> getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 * 
	 * @param map
	 *            the map
	 */
	public void setMap(HashMap<Character, Command> map) {
		this.map = map;
	}

}
