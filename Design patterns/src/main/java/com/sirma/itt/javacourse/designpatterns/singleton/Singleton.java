package com.sirma.itt.javacourse.designpatterns.singleton;

// TODO: Auto-generated Javadoc
/**
 * Singleton instance class.
 */
public final class Singleton {

	/** The instance. */
	private Singleton instance = null;

	/**
	 * Gets the single instance of Singleton.
	 * 
	 * @return single instance of Singleton
	 */
	public Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
			return instance;
		} else {
			return instance;
		}
	}

	/**
	 * Instantiates a new singleton.
	 */
	protected Singleton() {
	}
}
