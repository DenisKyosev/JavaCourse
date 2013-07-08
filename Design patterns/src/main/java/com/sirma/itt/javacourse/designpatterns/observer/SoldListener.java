package com.sirma.itt.javacourse.designpatterns.observer;

// TODO: Auto-generated Javadoc
/**
 * Show when the observer is notified that the list of products is updated.
 */
public class SoldListener implements Observer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Products list) {
		System.out.println("Sold products list updated to " + list);
	}

}
