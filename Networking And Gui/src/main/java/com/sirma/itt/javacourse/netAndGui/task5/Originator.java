package com.sirma.itt.javacourse.netAndGui.task5;

// TODO: Auto-generated Javadoc
/**
 * The Class Originator.
 */
public class Originator {

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
