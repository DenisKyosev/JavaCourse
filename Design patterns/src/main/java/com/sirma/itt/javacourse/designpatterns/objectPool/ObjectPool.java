package com.sirma.itt.javacourse.designpatterns.objectPool;

/**
 * Class creating an object pool.
 */
public class ObjectPool {

	/**
	 * Instantiates a new object pool.
	 * 
	 * @param max
	 *            the max capacity
	 */
	ObjectPool(int max) {
		this.max = max;
	}

	/** Max possible instances. */
	private int max = 10;

	/** free instances. */
	private int free = 0;

	/** Created instances. */
	private int created = -1;

	/** The instances. */
	private final Object[] instance = new Object[max];

	/**
	 * Acquire new instance.
	 * 
	 * @return the string
	 */
	public String acquire() {
		if (free == 0 && created < max) {
			created++;
			instance[created] = new Object();
			return "OK. Instance created";
		} else if (free > 0) {
			free--;
			return "OK.";
		} else {
			return "Error! Can't create more instances.";
		}

	}

	/**
	 * Release instance.
	 * 
	 * @return the string
	 */
	public String release() {
		if (created > -1) {
			free++;
			return "Instance released.";
		} else {
			return "No instances created.";
		}
	}
}
