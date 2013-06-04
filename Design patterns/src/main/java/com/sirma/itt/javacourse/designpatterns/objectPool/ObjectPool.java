package com.sirma.itt.javacourse.designpatterns.objectPool;

/**
 * Class creating a maximum number of instances.
 */
public class ObjectPool {

	/** Max possible instances. */
	private int max = 10;

	/**
	 * Gets the max.
	 * 
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Sets the max.
	 * 
	 * @param max
	 *            the new max
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/** Created instances. */
	private int created = -1;

	/** The instances. */
	private final ObjectPool[] instance = new ObjectPool[max];

	/**
	 * Acquire new instance.
	 * 
	 * @return the string
	 */
	public String acquire() {
		if (created < max) {
			instance[++created] = new ObjectPool();
			return "OK";
		} else {
			return "Error! Can't create more instances.";
		}
	}

	/**
	 * Release instance.
	 */
	public void release() {
		if (created > -1) {
			try {
				instance[created].finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			created--;
		}

	}
}
