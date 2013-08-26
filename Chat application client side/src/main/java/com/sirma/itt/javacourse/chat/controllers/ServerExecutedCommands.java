package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;

public class ServerExecutedCommands implements Command {
	Wrapper wrap;

	ServerExecutedCommands(Wrapper wrap) {
		this.wrap = wrap;
	}

	String command;
	String property;

	@Override
	public void execute(String command, String property) {
		this.command = command;
		this.property = property;
		switch (command) {
			case "usernameChange":
				usernameChange();
				break;
			case "usernameUnavailable":
				usernameUnavailable();
				break;
			case "connected":
				connected();
				break;
			case "serverClosed":
				serverClosed();
				break;
			case "incognito":
				incognito();
				break;
			case "userDisconnected":
				userDisconnected();
				break;
			default:
				invalidCommand();
				break;
		}
	}

	private void userDisconnected() {
		wrap.getMsg().setTextToBeUpdated("userLeft", property);
		wrap.getMsg().setTextToBeUpdated("Main area",
				property + " " + wrap.getLang().getValue("userDisconnected"));

	}

	private void invalidCommand() {
		// TODO Auto-generated method stub

	}

	private void incognito() {
		wrap.getMsg().setTextToBeUpdated("userLeft", property);
		wrap.getMsg().setTextToBeUpdated("Main area",
				property + " " + wrap.getLang().getValue("userDisconnected"));

	}

	private void serverClosed() {
		try {
			wrap.getClient().close();
		} catch (IOException e) {
		}
		wrap.setClient(null);

	}

	private void connected() {
		if (wrap.getMsg().hasUpdate("newUser")) {
			wrap.getMsg().setTextToBeUpdated("newUser", "::" + property);
		} else {
			wrap.getMsg().setTextToBeUpdated("newUser", property);
		}
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("userConnected") + property);

	}

	private void usernameUnavailable() {
		wrap.getMsg().setTextToBeUpdated("Main area",
				wrap.getLang().getValue("usernameUnavailable"));

	}

	private void usernameChange() {
		String oldUser = property.split("-")[0].trim();
		String newUser = property.split("-")[1].trim();
		wrap.getMsg().setTextToBeUpdated("userLeft", oldUser);
		wrap.getMsg().setTextToBeUpdated("newUser", newUser);
		wrap.getMsg().setTextToBeUpdated("Main area",
				oldUser + " " + wrap.getLang().getValue("usernameChange") + newUser);
		if (oldUser.equals(wrap.getUsername())) {
			wrap.setUsername(newUser);
		}

	}

}
