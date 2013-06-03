package com.sirma.itt.javacourse.inputoutput.transferObject;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * test class for TransferObject.
 */
public class TestTransferObject {

	/**
	 * Test transfer object.
	 * 
	 * @throws IOException
	 *             io exception
	 */
	@Test
	public void testTransferObject() throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream("hello world".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(in, out);

		assertEquals(4, transfer.transfer(4, 1));
		assertEquals(3, transfer.transfer(3, 2));
	}
}
