package com.sirma.itt.javacourse.netAndGui.task5;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerClientTest.
 */
public class ServerClientTest {

	/**
	 * Communication test.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void communicationTest() throws NoSocketException, IOException {

		Messenger msg = new Messenger();

		ServerFunctions server = new ServerFunctions(msg);
		assertEquals(true, server.openConnection());
		assertEquals("Server started on port: 7000\r\nWaiting for clients\r\n",
				msg.getServerTextArea());
		ClientFunctions client = new ClientFunctions(msg);

		client.openConnection();
		assertEquals("Client connected to server on port 7000\r\n", client.getMessage());

		server.acceptClient();
		client.getMessageFromServer();
		assertEquals("Welcome", client.getMessage());

		client.setSend("hello");
		client.setFlag(true);
		client.sendMessage();

		assertEquals("The reverse of [hello] is [olleh]", client.getMessage());

	}
}
