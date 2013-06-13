package com.sirma.itt.javacourse.designpatterns.objectPool;

import java.util.Stack;

/**
 * Class creating an object pool.
 */
public class ObjectPool {
	/** Max possible instances. */
	private int max = 10;

	private final Stack<Object> inUse;
	/** The instances. */
	private final Stack<Object> pool;

	/**
	 * Instantiates a new object pool.
	 * 
	 * @param max
	 *            the max capacity
	 */
	ObjectPool(int max) {
		inUse = new Stack<Object>();
		this.max = max;
		pool = new Stack<Object>();
	}

	/**
	 * Acquire new instance.
	 * 
	 * @return the string
	 */
	public Object acquire() {
		if (pool.isEmpty()) {
			inUse.add(new Object());
			return inUse.peek();
		} else if (inUse.size() == max) {
			return null;
		} else {
			inUse.add(pool.peek());
			return pool.pop();

		}
	}

	/**
	 * Release instance.
	 * 
	 * @return the string
	 */
	public String release() {
		if (inUse.size() > 0) {
			pool.add(inUse.pop());
			return "Object released";
		} else {
			return "No instances created.";
		}
	}
}
