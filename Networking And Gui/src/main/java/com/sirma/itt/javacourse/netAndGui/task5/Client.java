package com.sirma.itt.javacourse.netAndGui.task5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client extends JFrame {

	protected static JTextField getTxtField() {
		return txtField;
	}

	protected static void setTxtField(JTextField txtField) {
		Client.txtField = txtField;
	}

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	ClientFunctions client;
	/** The text area. */
	private static JTextArea txtArea;
	private static JTextField txtField;

	/**
	 * Instantiates a new client.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 */
	Client() throws NoSocketException, IOException {
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
		JButton send = new JButton("Send");

		JPanel inputField = new JPanel(new GridLayout(1, 2));
		mainPanel.add(inputField, BorderLayout.SOUTH);

		inputField.add(txtField);
		inputField.add(send);

		setVisible(true);
		txtArea.append("Trying to connect to server\r\n");

		client = new ClientFunctions(txtArea, txtField, send);

		client.openConnection();

	}

}