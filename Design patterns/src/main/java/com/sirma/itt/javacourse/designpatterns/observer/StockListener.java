package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * Show when the observer is notified that the list of products is updated.
 * 
 * @see StockEvent
 */
public class StockListener implements Observer {

	/** The updated. */
	private boolean updated;

	/**
	 * Invoked when Checks if is update occurs.
	 * 
	 * @return true, if checks if is updated
	 */
	protected boolean isUpdated() {
		return updated;
	}

	/**
	 * Invoked when Sets the update occurs.
	 * 
	 * @param updated
	 *            the updated
	 */
	protected void setUpdated(boolean updated) {
		this.updated = updated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Products list) {
		System.out.println("In stock products list was updated");
		updated = true;
	}

}
