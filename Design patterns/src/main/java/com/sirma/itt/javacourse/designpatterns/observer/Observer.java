package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;

/**
 * The Interface Observer.
 */
public interface Observer {

	/**
	 * Update observers states.
	 * 
	 * @param list
	 *            the list
	 */
	void update(ArrayList<Product> list);
}
