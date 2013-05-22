package com.sirma.itt.javacourse.inputoutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

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
	 */
	public static void main(String[] args) {
		ByteArrayInputStream in = new ByteArrayInputStream("hello world".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(in, out);

		System.out.println(transfer.transfer(4, 0));
	}
}
