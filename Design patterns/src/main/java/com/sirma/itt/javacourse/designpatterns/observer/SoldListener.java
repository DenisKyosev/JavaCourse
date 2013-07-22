package com.sirma.itt.javacourse.designpatterns.observer;

// TODO: Auto-generated Javadoc
/**
 * Show when the observer is notified that the list of products is updated.
 * 
 * @see SoldEvent
 */
public class SoldListener implements Observer {

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
	public void update() {
		updated = true;
		System.out.println("Sold products list updated");
	}

}
