package com.sirma.itt.javacourse.netAndGui.task5;

// TODO: Auto-generated Javadoc
/**
 * The Class Originator.
 */
public class Originator {

	/** current list position. */
	private int current = 0;

	/**
	 * Gets the current list position.
	 * 
	 * @return the current list position
	 */
	protected int getCurrent() {
		return current;
	}

	/**
	 * Sets the current list position.
	 * 
	 * @param current
	 *            the new list position
	 */
	protected void setCurrent(int current) {
		this.current = current;
	}

	/**
	 * Save to memento.
	 * 
	 * @param save
	 *            the save
	 * @return the memento
	 */
	public Memento saveToMemento(String save) {
		return new Memento(save);
	}

	/**
	 * Restore from memento.
	 * 
	 * @param memento
	 *            the memento
	 * @return restored string
	 */
	public String restoreFromMemento(Memento memento) {
		return memento.getSavedState();
	}

}
