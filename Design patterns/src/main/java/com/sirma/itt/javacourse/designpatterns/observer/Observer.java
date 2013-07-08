package com.sirma.itt.javacourse.designpatterns.observer;


/**
 * The Interface Observer.
 */
public interface Observer {

	/**
	 * Update observers states.
	 * 
	 * @param products
	 *            the list
	 */
	void update(Products products);
}
