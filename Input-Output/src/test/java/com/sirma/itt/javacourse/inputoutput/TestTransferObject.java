package com.sirma.itt.javacourse.inputoutput;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

/**
 * test class for TransferObject.
 */
public class TestTransferObject {

	/**
	 * Test transfer object.
	 */
	@Test
	public void testTransferObject() {
		ByteArrayInputStream in = new ByteArrayInputStream("hello world".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(in, out);

		assertEquals(4, transfer.transfer(4, 1));
		assertEquals(3, transfer.transfer(3, 2));
	}
}
