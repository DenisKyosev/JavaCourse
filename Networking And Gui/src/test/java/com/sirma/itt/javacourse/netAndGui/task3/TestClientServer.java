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
		Messenger msg = new Messenger();
		ServerFunctions server = new ServerFunctions(msg);

		assertEquals(true, server.serverStarted());
		assertEquals("Server started on port: 7000\r\nWaiting for clients\r\n",
				msg.getServerTextArea());

		ClientFunctions client = new ClientFunctions(msg);
		server.sendMessage(client.getClient());
		client.getMessage();

		assertEquals(true, client.clientConnected());
		assertEquals(true, msg.getClientTextArea().contains("Hello"));
		assertEquals(true, msg.getServerTextArea().contains("Hello"));

		assertNotEquals(null, Connect.openServerSocket());
		assertNotEquals(null, Connect.openSocket());
	}
}
