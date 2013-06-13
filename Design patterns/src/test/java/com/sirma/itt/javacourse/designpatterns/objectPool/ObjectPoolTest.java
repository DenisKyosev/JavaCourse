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
		ObjectPool pool = new ObjectPool(2);

		assertEquals("No instances created.", pool.release());

		for (int i = 0; i < 3; i++) {
			assertEquals("OK. Instance created", pool.acquire());
		}
		assertEquals("Error! Can't create more instances.", pool.acquire());

		assertEquals("Instance released.", pool.release());
		assertEquals("Instance released.", pool.release());
		assertEquals("OK.", pool.acquire());
		assertEquals("OK.", pool.acquire());
		assertEquals("Error! Can't create more instances.", pool.acquire());
	}

}
