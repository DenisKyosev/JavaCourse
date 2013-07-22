package com.sirma.itt.javacourse.netAndGui.task6;

public class Messenger {
	static String serverMessage = "";
	static boolean updateServer = false;
	static String clientMessage = "";
	static boolean updateClient = false;

	protected String getServerMessage() {
		updateServer = false;
		return serverMessage;
	}

	protected void setServerMessage(String serverMessage) {
		updateServer = true;
		this.serverMessage += serverMessage;
	}

	protected boolean isUpdateServer() {
		return updateServer;
	}

	protected String getClientMessage() {
		updateClient = false;
		return clientMessage;
	}

	protected void setClientMessage(String clientMessage) {
		updateClient = true;
		this.clientMessage += clientMessage;
	}

	protected boolean isUpdateClient() {
		return updateClient;
	}

}
