package com.sirma.itt.javacourse.chat.controllers;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientsListUpdater implements Runnable {
	List<String> clients = new ArrayList<String>();
	Socket client;
	ClientMessenger connection;
	InterfaceUpdater msg;

	ClientsListUpdater(Socket client, InterfaceUpdater msg) {
		this.client = client;
		this.msg = msg;
		connection = new ClientMessenger(client);
	}

	private void listUpdate() {
		String message = connection.receive();
		if (message.contains("<new user>")) {
			msg.setTextToBeUpdated("Users newUser", message.split("(<new user>)(.*)")[1]);
		} else if (message.contains("<user left>")) {
			msg.setTextToBeUpdated("Users leftUser", message.split("(<user left>)(.*)")[1]);
		}
	}

	@Override
	public void run() {
		while (true) {
			listUpdate();
		}
	}

}
