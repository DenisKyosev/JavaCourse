package com.sirma.itt.javacourse.netAndGui.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mediator {
	private final List<ClientConnector> clientList;
	private static Map<Integer, List<ClientConnector>> connections = new HashMap<Integer, List<ClientConnector>>();
	boolean newUser = false;

	Mediator() {
		clientList = new ArrayList<ClientConnector>();
		for (int j = 1; j < 10; j++) {
			connections.put(j, clientList);
		}

	}

	void newUser(ClientConnector client, int channel) {
		if (connections.containsKey(channel)) {
			connections.get(channel).add(client);
			client.send("Connected to channel: " + channel + "\r\n");
		} else {
			client.send("No such channel\r\n");
		}
	}

	void sendMessage(int channel) {
		System.out.println(connections.get(channel).size());
		for (int i = 0; i < connections.get(channel).size(); i++) {
			connections.get(channel).get(i).send("Server sent you a message on channel " + channel);
		}
	}
}
