package com.sirma.itt.javacourse.netAndGui.task5;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

		JTextArea dummyTextArea = new JTextArea();
		JTextField dummyTextField = new JTextField();
		JButton dummyButton = new JButton();

		ServerFunctions server = new ServerFunctions(dummyTextArea);
		assertEquals("Server started on port: 7000\r\nWaiting for clients\r\n",
				server.openConnection());
		ClientFunctions client = new ClientFunctions(dummyTextArea, dummyTextField, dummyButton);

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
