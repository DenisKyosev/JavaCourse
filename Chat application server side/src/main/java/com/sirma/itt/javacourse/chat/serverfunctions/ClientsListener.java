package com.sirma.itt.javacourse.chat.serverfunctions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sirma.itt.javacourse.chat.controllers.InterfaceUpdater;
import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

public class ClientsListener implements Runnable {
	ServerSocket server;
	InterfaceUpdater msg;
	Wrapper wrap;
	boolean stop = false;

	public ClientsListener(Wrapper wrap) {
		this.server = wrap.getServer();
		this.msg = wrap.getMsg();
		this.wrap = wrap;
	}

	private Socket acceptNewClient() {
		Socket client = null;
		try {
			client = server.accept();
			msg.setTextToBeUpdated("Main area", wrap.getLang().getValue("newClientConnected"));
		} catch (IOException e) {
			stop = true;
		}

		return client;
	}

	private boolean checkUsername(Socket client) {
		if (client != null) {
			ServerMessenger messenger = new ServerMessenger(client);
			String username = messenger.receive();
			if (wrap.getUsersList().contains(username)) {
				messenger.send("Username unavailable");
				msg.setTextToBeUpdated("Main area", wrap.getLang().getValue("usernameUnavailable")
						+ username);
				return false;
			} else {
				wrap.getUsersList().add(username);
				messenger.send(buildUsersList());
				msg.setTextToBeUpdated("new user", username);
				msg.setTextToBeUpdated("Main area", wrap.getLang().getValue("userAddedToList")
						+ username);
				ClientsLogoutListener logoutListener = new ClientsLogoutListener(messenger, wrap);
				new Thread(logoutListener).start();
				return true;
			}
		}
		return false;
	}

	private String buildUsersList() {
		String list = "";
		for (int i = 0; i < wrap.getUsersList().size(); i++) {
			list += wrap.getUsersList().get(i);
			if (i != wrap.getUsersList().size() - 1) {
				list += ";";
			}
		}
		return list.toString();
	}

	@Override
	public void run() {
		while (!stop) {
			Socket client = acceptNewClient();
			checkUsername(client);
		}
	}
}
