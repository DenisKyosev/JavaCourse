package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * Show when the observer is notified that the list of products is updated.
 * 
 * @see StockEvent
 */
public class StockListener implements Observer {

	/** The updated. */
	private boolean updated = false;

	/**
	 * Invoked when Checks if is update occurs.
	 * 
	 * @return true, if checks if is updated
	 */
	protected boolean isUpdated() {
		return updated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(String product) {
		System.out.println("In stock products list was updated. Product added: " + product);
		updated = true;
	}
}
