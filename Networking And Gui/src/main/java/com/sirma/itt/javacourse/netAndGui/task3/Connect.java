package com.sirma.itt.javacourse.netAndGui.task3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * The Class Connect.
 */
public final class Connect {

	/**
	 * Instantiates a new connect.
	 */
	private Connect() {

	}

	/**
	 * Open client socket on port range 7000-7020.
	 * 
	 * @return the socket
	 */
	protected static Socket openSocket() {
		for (int i = 7000; i < 7020; i++) {
			try {
				return new Socket("localhost", i);
			} catch (IOException e) {

			}
		}
		return null;
	}

	/**
	 * Open server socket on port range 7000-7020.
	 * 
	 * @return the server socket
	 */
	protected static ServerSocket openServerSocket() {
		for (int i = 7000; i <= 7020; i++) {
			try {
				return new ServerSocket(i);
			} catch (IOException ex) {
				continue;
			}
		}
		return null;
	}

}
