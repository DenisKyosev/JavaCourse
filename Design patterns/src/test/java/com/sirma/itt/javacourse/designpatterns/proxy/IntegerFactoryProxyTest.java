package com.sirma.itt.javacourse.designpatterns.proxy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerFactoryProxyTest.
 */
public class IntegerFactoryProxyTest {

	/**
	 * Test proxy.
	 */
	@Test
	public void testProxy() {
		IntegerFactory proxy = new IntegerFactory();
		assertEquals(13, proxy.createInstance().getRealNumber());

	}
}
