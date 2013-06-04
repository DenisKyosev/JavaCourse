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
		ObjectPool pool = new ObjectPool();
		System.out.println(pool.acquire());
		pool.release();
	}

}
