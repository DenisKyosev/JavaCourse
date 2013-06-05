package com.sirma.itt.javacourse.designpatterns.observer;

// TODO: Auto-generated Javadoc
/**
 * The Interface Subject.
 */
interface Subject {

	/**
	 * Register observer.
	 * 
	 * @param observer
	 *            the observer
	 */
	void registerObserver(Observer observer);

	/**
	 * Removes the observer.
	 * 
	 * @param observer
	 *            the observer
	 */
	void removeObserver(Observer observer);

	/**
	 * Notify observers.
	 */
	void notifyObservers();
}