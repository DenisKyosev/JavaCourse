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
 * Client window functions.
 */
public class ClientFunctions implements ActionListener, KeyListener {
	/** The client socket. */
	private Socket client;

	/** The out. */
	private PrintWriter out;
	/** The message. */
	private String message;

	/** The flag. */
	private boolean flag = false;
	/** The txt area. */
	private final JTextArea txtArea;

	/** The send. */
	private String send = "";

	/** The send btn. */
	private final JButton sendBtn;

	/** The memento. */
	private Originator memento;

	/** The saved states. */
	private List<Memento> savedStates;

	/** The current. */
	private int current = 0;

	/**
	 * Instantiates a new client functions.
	 * 
	 * @param txtArea
	 *            the text area
	 * @param sendBtn
	 *            the send button
	 * @param txtField
	 *            the text field
	 * @throws NoSocketException
	 * @throws IOException
	 */
	ClientFunctions(JTextArea txtArea, JTextField txtField, JButton sendBtn)
			throws NoSocketException, IOException {
		this.txtArea = txtArea;
		this.sendBtn = sendBtn;
		sendBtn.addActionListener(this);
		txtField.addKeyListener(this);
		client = new Socket();

	}

	/**
	 * Open connection.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
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

		}

	}

	/**
	 * Send message.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 */
	void sendMessage() throws NoSocketException, IOException {
		if (!send.contains(".")) {
			if (flag) {
				savedStates.add(memento.saveToMemento(send));
				out.println(send);
				out.flush();
				getMessageFromServer();
				flag = false;
				current++;
			}
		} else {
			client.close();
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

		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			message = stream.readLine();
			txtArea.append(message + "\r\n");
		} catch (IOException e) {
			throw new NoSocketException();
		}
	}

	protected void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}

	/**
	 * Sets the send.
	 * 
	 * @param send
	 *            the new send
	 */
	protected void setSend(String send) {
		this.send = send;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sendBtn) {
			send = Client.getTxtField().getText();
			flag = true;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
