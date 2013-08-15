package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnector {
	Wrapper wrap;

	ClientConnector(Wrapper wrap) {
		this.wrap = wrap;
	}

	public boolean openSocket(String host, int port, String username) {
		try {
			wrap.setClient(new Socket(host, port));

			wrap.getMsg().setTextToBeUpdated("Main area",
					wrap.getLang().getValue("connectionSuccess"));

			wrap.setMessenger(new ClientMessenger(wrap.getClient()));
			wrap.getMessenger().send(username);
			String message = wrap.getMessenger().receive();

			if (message.contains("unavailable")) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("usernameUnavailable"));
				wrap.getClient().close();
				wrap.setClient(null);
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("disconnected"));
				return true;
			} else {
				System.out.println(message);
				wrap.getMsg().setTextToBeUpdated("Users newUser", message);
				return false;
			}
		} catch (UnknownHostException e) {
			wrap.getMsg()
					.setTextToBeUpdated("Main area", wrap.getLang().getValue("connectionFail"));
		} catch (IOException e) {
			wrap.getMsg()
					.setTextToBeUpdated("Main area", wrap.getLang().getValue("connectionFail"));
		}
		return false;
	}
}
