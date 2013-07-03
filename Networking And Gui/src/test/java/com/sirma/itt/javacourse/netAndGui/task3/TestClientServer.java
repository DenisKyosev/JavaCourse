package com.sirma.itt.javacourse.netAndGui.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
				server.serverStarted());

		ClientFunctions client = new ClientFunctions();

		assertEquals(true, server.sendMessage(client.getClient()).contains("Hello"));

		assertNotEquals(null, Connect.openServerSocket());
		assertNotEquals(null, Connect.openSocket());
	}
}
