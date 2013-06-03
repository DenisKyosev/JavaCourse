package com.sirma.itt.javacourse.inputoutput.transferObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * run class for TransferObject.
 */
public final class RunTransferObject {

	/**
	 * Instantiates a new run transfer object.
	 */
	private RunTransferObject() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             io exception
	 */
	public static void main(String[] args) throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream("hello world".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(in, out);

		System.out.println(transfer.transfer(4, 0));
	}
}
