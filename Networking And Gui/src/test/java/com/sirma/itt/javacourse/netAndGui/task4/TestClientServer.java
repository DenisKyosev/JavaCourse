package com.sirma.itt.javacourse.netAndGui.task4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class TestClientServer.
 */
public class TestClientServer {

	/**
	 * Test client server connections.
	 */
	@Test
	public void testClientServerConnections() {

		ServerFunctions server = new ServerFunctions();
		assertEquals("Server started on port: 7000\r\nWaiting for clients\r\n",
				server.openConnection());

		ClientFunctions client = new ClientFunctions(new JTextArea());

		try {
			client.openConnection();
		} catch (NoSocketException e1) {
			e1.printStackTrace();
		}

		assertEquals("New client connected. \r\n Number of clients:1\r\n", server.acceptClient());

		assertEquals("Client connected to server on port 7000\r\n", client.getMessage());

		assertEquals("New client connected. \r\n Number of clients:2\r\n", server.acceptClient());

		assertNotEquals(null, Connect.openServerSocket());
		assertNotEquals(null, Connect.openSocket());
	}
}
