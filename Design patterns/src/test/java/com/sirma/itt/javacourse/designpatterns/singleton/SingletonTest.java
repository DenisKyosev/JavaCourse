package com.sirma.itt.javacourse.designpatterns.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class SingletonTest.
 */
public class SingletonTest {

	/**
	 * Test singleton.
	 */
	@Test
	public void testSingleton() {
		Singleton singleton = new Singleton();
		String firstInstance = singleton.getInstance().toString();
		assertEquals(firstInstance, singleton.getInstance().toString());
		assertEquals(firstInstance, singleton.getInstance().toString());
		assertEquals(firstInstance, singleton.getInstance().toString());
	}
}
