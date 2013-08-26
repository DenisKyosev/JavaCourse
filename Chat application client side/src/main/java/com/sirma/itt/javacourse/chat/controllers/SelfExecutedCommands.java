package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;

public class SelfExecutedCommands implements Command {
	Wrapper wrap;

	SelfExecutedCommands(Wrapper wrap) {
		this.wrap = wrap;
	}

	@Override
	public void execute(String command, String property) {
		switch (command) {
			case "help":
				help();
				break;
			case "disconnect":
				disconnect();
				break;
			default:
				invalidCommand();
				break;
		}
	}

	private void invalidCommand() {
		// TODO Auto-generated method stub

	}

	private void disconnect() {

		wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("disconnected"));
		try {
			wrap.getClient().close();
		} catch (IOException e) {
		}
		wrap.setClient(null);

	}

	private void help() {
		String result = wrap.getLang().getValue("help") + "\r\n";
		result += wrap.getLang().getValue("helpCommand") + "\r\n";
		result += wrap.getLang().getValue("usernameCommand") + "\r\n";
		result += wrap.getLang().getValue("disconnectCommand") + "\r\n";
		result += wrap.getLang().getValue("incognitoCommand") + "\r\n";
		result += wrap.getLang().getValue("infoCommand") + "\r\n";
		wrap.getMsg().setTextToBeUpdated("Main area", result);

	}

}
