package com.sirma.itt.javacourse.designpatterns.objectPool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectPoolTest.
 */
public class ObjectPoolTest {

	/**
	 * Test pool.
	 */
	@Test
	public void testPool() {
		ObjectPool pool = new ObjectPool();
		for (int i = 0; i < 10; i++) {
			assertEquals("OK", pool.acquire());
		}
		assertEquals("Error! Can't create more instances.", pool.acquire());
	}

}
