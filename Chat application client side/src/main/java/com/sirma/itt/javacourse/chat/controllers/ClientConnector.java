package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnector {
	InterfaceUpdater msg;

	public ClientConnector(InterfaceUpdater msg) {
		this.msg = msg;
	}

	public Socket openSocket(String host, int port, String username) {
		Socket client;
		try {
			client = new Socket(host, port);
			ClientMessenger messenger = new ClientMessenger(client);
			messenger.send(username);
		} catch (UnknownHostException e) {
			msg.setTextToBeUpdated("Main area", msg.getText("clientConnectError"));
		} catch (IOException e) {
			msg.setTextToBeUpdated("Main area", msg.getText("clientConnectError"));
		}
		return null;
	}
}
