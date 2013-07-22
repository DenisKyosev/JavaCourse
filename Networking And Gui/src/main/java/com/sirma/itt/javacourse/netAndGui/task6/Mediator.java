package com.sirma.itt.javacourse.netAndGui.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Mediator.
 */
public class Mediator {

	/** The connections. */
	private final Map<Integer, List<ClientConnector>> connections = new HashMap<Integer, List<ClientConnector>>();

	/**
	 * Instantiates a new mediator.
	 */
	Mediator() {
		for (int j = 1; j < 10; j++) {
			connections.put(j, new ArrayList<ClientConnector>());
		}
	}

	/**
	 * New user.
	 * 
	 * @param client
	 *            the client
	 * @param channel
	 *            the channel
	 */
	void newUser(ClientConnector client, int channel) {
		if (connections.containsKey(channel)) {
			connections.get(channel).add(client);
			System.out.println(connections.get(channel).size());
			client.send("Connected to channel: " + channel + "\r\n");
		} else {
			client.send("No such channel\r\n");
		}
	}

	/**
	 * Send message.
	 * 
	 * @param channel
	 *            the channel
	 */
	void sendMessage(int channel) {
		System.out.println(connections.get(channel).size());
		for (int i = 0; i < connections.get(channel).size(); i++) {
			connections.get(channel).get(i).send("Server sent you a message on channel " + channel);
		}
	}
}
