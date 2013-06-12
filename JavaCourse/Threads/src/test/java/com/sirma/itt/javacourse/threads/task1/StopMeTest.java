package com.sirma.itt.javacourse.threads.task1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class StopMeTest.
 */
public class StopMeTest {

	/**
	 * Test stop counter.
	 */
	@Test
	public void testStopCounter() {
		StopMe count = new StopMe(10);
		Thread counting = new Thread(count);
		counting.start();

		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, count.getCounter());

		try {
			Thread.sleep(2100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, count.getCounter());
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		assertEquals(false, counting.isAlive());
	}

	/**
	 * Test stop counter interrupted by input.
	 */
	@Test
	public void testStopCounterInterruptByInput() {
		StopMe count = new StopMe(10);
		Thread counting = new Thread(count);
		counting.start();
		String input = "aaaa";

		assertEquals(true, counting.isAlive());
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
		}

		count.read(new ByteArrayInputStream(input.getBytes()));
		assertEquals(2, count.getCounter());

		try {
			Thread.sleep(2200);
		} catch (InterruptedException e) {
		}

		assertEquals(2, count.getCounter());
		assertEquals(false, counting.isAlive());
	}
}
