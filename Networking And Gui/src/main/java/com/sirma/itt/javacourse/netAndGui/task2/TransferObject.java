package com.sirma.itt.javacourse.netAndGui.task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Class TransferObject.
 */
public class TransferObject {

	/** The in. */
	private InputStream in;
	private int read = 0;

	protected int getRead() {
		return read;
	}

	protected void setRead(int read) {
		this.read = read;
	}

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
	protected int transfer(int numberOfBytes, int offset) throws IOException {

		int lastRead = 0;
		boolean flag = true;
		in.skip(offset);

		int readed = 0;

		byte[] buf = new byte[1024];
		int len;
		len = in.read(buf);
		while (len > 0 && read < numberOfBytes) {
			out.write(buf, 0, len);
			read += len;
			len = in.read(buf);
		}

		in.close();
		out.close();
		return readed;
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
