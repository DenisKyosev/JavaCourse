package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client extends JFrame implements Runnable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The text area. */
	private final JTextArea txtArea;
	private final Messenger msg = new Messenger();

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
		ClientFunctions client = new ClientFunctions(msg);
		Thread thread = new Thread(this);
		thread.start();
		client.clientConnected();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			if (msg.clientFlagUp()) {
				txtArea.append(msg.getClientTextArea());
			}
		}

	}

}