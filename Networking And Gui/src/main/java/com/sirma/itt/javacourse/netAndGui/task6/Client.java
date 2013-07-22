package com.sirma.itt.javacourse.netAndGui.task6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * Client window GUI.
 */
public class Client extends JFrame implements ActionListener, Runnable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The text area. */
	private static JTextArea txtArea;

	/** The text field. */
	private static JTextField txtField;

	/** The client. */
	private final ClientFunctions client;

	/** The message. */
	private final Messenger msg;

	/**
	 * Instantiates a new client.
	 */
	Client() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel outputField = new JPanel(new BorderLayout(30, 30));

		outputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(outputField);

		txtArea = new JTextArea();
		txtArea.setFocusable(false);
		outputField.add(txtArea);

		txtField = new JTextField();
		JButton send = new JButton("Join channel");

		JPanel inputField = new JPanel(new GridLayout(1, 3));
		mainPanel.add(inputField, BorderLayout.SOUTH);

		JLabel channel = new JLabel("Enter channel(1-10)");
		inputField.add(channel);
		inputField.add(txtField);
		inputField.add(send);
		send.addActionListener(this);
		setVisible(true);

		msg = new Messenger();
		msg.setClientMessage("Trying to connect to server\r\n");

		client = new ClientFunctions();

		Thread thread = new Thread(client);
		thread.start();

		thread = new Thread(this);
		thread.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		client.send(txtField.getText());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (msg.isUpdateClient()) {
				txtArea.setText(msg.getClientMessage());
			}
		}
	}
}