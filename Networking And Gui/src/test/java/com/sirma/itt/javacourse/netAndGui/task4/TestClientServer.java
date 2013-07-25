package com.sirma.itt.javacourse.netAndGui.task4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
		Messenger msg = new Messenger();
		ServerFunctions server = new ServerFunctions(msg);

		assertEquals(true, server.openConnection());
		assertEquals("Server started on port: 7000\r\nWaiting for clients\r\n",
				msg.getServerTextArea());

		@SuppressWarnings("unused")
		ClientFunctions client = null;
		try {
			client = new ClientFunctions(msg);
		} catch (NoSocketException e) {
		}

		assertEquals(true, server.acceptClient());
		assertEquals("New client connected. \r\n Number of clients:1\r\n", msg.getServerTextArea());

		assertEquals("Client connected to server on port 7000\r\n", msg.getClientTextArea());

		try {
			client = new ClientFunctions(msg);
		} catch (NoSocketException e) {
		}

		assertEquals(true, server.acceptClient());
		assertEquals("New client connected. \r\n Number of clients:2\r\n", msg.getServerTextArea());

	}
}
