package com.sirma.itt.javacourse.netAndGui.task6;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

public class Task6Test {
	@Test
	public void communicationTest() throws NoSocketException, IOException {

		Messenger msg = new Messenger();
		Mediator mediator = new Mediator();
		Socket client = new Socket();
		ServerSocket server = new ServerSocket();
		ClientFunctions clientFunctions = new ClientFunctions(msg);

		server = Connect.openServerSocket();
		client = Connect.openSocket();

		clientFunctions.openConnection();
		ChannelsListener channels = new ChannelsListener(client, mediator, msg);

		assertEquals("Client connected to server on port: 7000\r\n", msg.getClientMessage());

	}
}
