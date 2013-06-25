package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The client socket. */
	private final Socket client;

	/** The text area. */
	private final JTextArea txtArea;

	/**
	 * Instantiates a new client.
	 */
	Client() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(inputField);

		txtArea = new JTextArea();
		txtArea.setFocusable(false);

		inputField.add(txtArea);

		setVisible(true);
		txtArea.append("Trying to connect to server\r\n");
		client = Connect.openSocket();
		if (client == null) {
			txtArea.append("No server running on port in range 7000-7020.");
		} else {
			getMessage(client);
			txtArea.append("Connection terminated");

		}

	}

	/**
	 * Gets message from server.
	 * 
	 * @param client
	 *            the client socket
	 */
	void getMessage(Socket client) {
		txtArea.append("Client connected to server on port " + Integer.toString(client.getPort())
				+ "\r\n");
		String message;
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			message = stream.readLine();
			txtArea.append(message + "\r\n");
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}