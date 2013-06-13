package com.sirma.itt.javacourse.designpatterns.objectPool;

// TODO: Auto-generated Javadoc
/**
 * Run class for ObjectPool.
 */
public final class RunObjectPool {

	/**
	 * Instantiates a new run object pool.
	 */
	private RunObjectPool() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {
		ObjectPool pool = new ObjectPool(3);
		System.out.println(pool.acquire());

		System.out.println(pool.release());

		System.out.println(pool.acquire());
		System.out.println(pool.acquire());
		System.out.println(pool.acquire());

		System.out.println(pool.release());
		System.out.println(pool.release());

		System.out.println(pool.acquire());
		System.out.println(pool.acquire());
	}
}
