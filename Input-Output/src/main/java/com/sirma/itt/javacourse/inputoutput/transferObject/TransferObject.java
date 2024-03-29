package com.sirma.itt.javacourse.inputoutput.transferObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Class TransferObject.
 */
public class TransferObject {

	/** The in. */
	private InputStream in;

	/** The out. */
	private OutputStream out;

	/**
	 * Instantiates a new transfer object.
	 * 
	 * @param in
	 *            the in
	 * @param out
	 *            the out
	 */
	protected TransferObject(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;

	}

	/**
	 * Transfer.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes to be transfered
	 * @param offset
	 *            the offset
	 * @return size
	 * @throws IOException
	 *             io exception
	 */
	protected long transfer(int numberOfBytes, int offset) throws IOException {
		byte[] buff = new byte[numberOfBytes];
		long size = 0;

		in.skip(offset);
		size = in.read(buff, 0, numberOfBytes);
		out.write(buff);

		return size;
	}

	/**
	 * Getter method for in.
	 * 
	 * @return the in
	 */
	protected InputStream getIn() {
		return in;
	}

	/**
	 * Setter method for in.
	 * 
	 * @param in
	 *            the in to set
	 */
	protected void setIn(InputStream in) {
		this.in = in;
	}

	/**
	 * Getter method for out.
	 * 
	 * @return the out
	 */
	protected OutputStream getOut() {
		return out;
	}

	/**
	 * Setter method for out.
	 * 
	 * @param out
	 *            the out to set
	 */
	protected void setOut(OutputStream out) {
		this.out = out;
	}

}
