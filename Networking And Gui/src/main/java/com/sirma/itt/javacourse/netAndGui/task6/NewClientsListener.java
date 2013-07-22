package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NewClientsListener implements Runnable {
	ServerSocket server;
	Socket client;
	static boolean updated = false;
	String message;
	Messenger msg;

	NewClientsListener(ServerSocket server) {
		this.server = server;
		msg = new Messenger();
	}

	@Override
	public void run() {
		while (true) {
			try {
				client = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ChannelsListener newClient = new ChannelsListener(client);
			Thread thread = new Thread(newClient);
			thread.start();

			msg.setServerMessage("New client connected\r\n");
		}
	}

	protected String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	protected boolean isUpdated() {
		return updated;
	}

	protected void setUpdated(boolean updated) {
		this.updated = updated;
	}
}
