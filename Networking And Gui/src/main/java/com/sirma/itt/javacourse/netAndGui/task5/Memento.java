package com.sirma.itt.javacourse.netAndGui.task5;

// TODO: Auto-generated Javadoc
/**
 * The Class Memento.
 */
public class Memento {

	/** The state. */
	private final String state;

	/**
	 * Instantiates a new memento.
	 * 
	 * @param stateToSave
	 *            the state to save
	 */
	public Memento(String stateToSave) {
		state = stateToSave;
	}

	/**
	 * Gets the saved state.
	 * 
	 * @return the saved state
	 */
	public String getSavedState() {
		return state;
	}
}