package com.sirma.itt.javacourse.netAndGui.task6;

import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Mediator implements Runnable {
	Map<Integer, List<Socket>> connections = new HashMap();
	boolean newUser = false;

	void newUser(Socket client, int channel) {
		connections.put(channel, connections.get(channel).add(client));
		newUser = true;
	}

	sendMessage(int channel, String message) {
		connections.
	}

	@Override
	public void run() {

	}
}
