package com.sirma.itt.javacourse.designpatterns.objectPool;

public class RunObjectPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectPool pool = new ObjectPool();
		System.out.println(pool.acquire());
		pool.release();
	}

}
