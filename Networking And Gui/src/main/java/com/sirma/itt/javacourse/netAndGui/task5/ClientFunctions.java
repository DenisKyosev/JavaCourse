package com.sirma.itt.javacourse.netAndGui.task5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientFunctions.
 */
public class ClientFunctions implements ActionListener, KeyListener {
	/** The client socket. */
	private Socket client;
	PrintWriter out;
	/** The message. */
	private String message;
	boolean flag = false;
	/** The txt area. */
	private final JTextArea txtArea;
	JTextField txtField;
	String send = "";
	JButton sendBtn;
	Originator memento;
	List<Memento> savedStates;
	int current = 0;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param txtArea
	 *            the txt area
	 */
	ClientFunctions(JTextArea txtArea, JTextField txtfField, JButton sendBtn) {
		this.txtArea = txtArea;
		this.txtField = txtField;
		this.sendBtn = sendBtn;
		sendBtn.addActionListener(this);
		txtfField.addKeyListener(this);
		client = new Socket();
	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 */
	void openConnection() throws NoSocketException, IOException {
		client = Connect.openSocket();
		memento = new Originator();
		savedStates = new ArrayList<Memento>();
		message = "No server running on port in range 7000-7020.";

		try {
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (client == null) {
			txtArea.append(message);
		} else {
			message = "Client connected to server on port " + Integer.toString(client.getPort())
					+ "\r\n";
			txtArea.append(message);
			getMessageFromServer();
		}

		sendMessage();
	}

	void sendMessage() throws NoSocketException {
		while (!send.contains(".")) {
			if (flag) {
				savedStates.add(memento.saveToMemento(send));
				out.println(send);
				out.flush();
				getMessageFromServer();
				flag = false;
				current++;
			}
		}
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	protected Socket getClient() {
		return client;
	}

	/**
	 * Gets message from server. the client socket
	 * 
	 * @throws NoSocketException
	 *             the server is closed
	 */
	void getMessageFromServer() throws NoSocketException {
		String receivedMsg = null;

		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			receivedMsg = stream.readLine();
			txtArea.append(receivedMsg + "\r\n");

		} catch (IOException e) {
			throw new NoSocketException();
		}
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}

	protected void setSend(String send) {
		this.send = send;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sendBtn) {
			send = Client.getTxtField().getText();
			flag = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38 && current > 0) {
			current--;
			Client.getTxtField().setText(savedStates.get(current).getSavedState());

		}
		if (e.getKeyCode() == 40 && current < savedStates.size() - 1) {
			current++;
			Client.getTxtField().setText(savedStates.get(current).getSavedState());

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
