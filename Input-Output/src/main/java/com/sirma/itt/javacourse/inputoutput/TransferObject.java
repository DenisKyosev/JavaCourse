package com.sirma.itt.javacourse.inputoutput;

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
	TransferObject(InputStream in, OutputStream out) {
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
	 */
	public int transfer(int numberOfBytes, int offset) {
		byte[] buff = new byte[numberOfBytes];
		int size = 0;
		try {
			in.skip(offset);
			size = in.read(buff, 0, numberOfBytes);
			out.write(buff);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return size;
	}

	/**
	 * Getter method for in.
	 * 
	 * @return the in
	 */
	public InputStream getIn() {
		return in;
	}

	/**
	 * Setter method for in.
	 * 
	 * @param in
	 *            the in to set
	 */
	public void setIn(InputStream in) {
		this.in = in;
	}

	/**
	 * Getter method for out.
	 * 
	 * @return the out
	 */
	public OutputStream getOut() {
		return out;
	}

	/**
	 * Setter method for out.
	 * 
	 * @param out
	 *            the out to set
	 */
	public void setOut(OutputStream out) {
		this.out = out;
	}

}
