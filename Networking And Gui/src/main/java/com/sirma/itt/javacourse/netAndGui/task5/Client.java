package com.sirma.itt.javacourse.netAndGui.task5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * Client window GUI.
 */
public class Client extends JFrame implements Runnable, ActionListener, KeyListener {

	/**
	 * Gets the text field.
	 * 
	 * @return the text field
	 */
	protected static JTextField getTxtField() {
		return txtField;
	}

	/**
	 * Sets the txt field.
	 * 
	 * @param txtField
	 *            the new txt field
	 */
	protected static void setTxtField(JTextField txtField) {
		Client.txtField = txtField;
	}

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The client. */
	private final ClientFunctions client;
	/** The text area. */
	private static JTextArea txtArea;
	private final Messenger msg = new Messenger();

	/** The text field. */
	private static JTextField txtField;
	/** The saved states. */
	private final List<Memento> savedStates;

	/** The memento. */
	private final Originator memento;

	/**
	 * Instantiates a new client.
	 * 
	 * @throws NoSocketException
	 *             the no socket exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
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
		txtField.addKeyListener(this);
		JButton send = new JButton("Send");
		send.addActionListener(this);
		send.setActionCommand("button1");

		JPanel inputField = new JPanel(new GridLayout(1, 2));
		mainPanel.add(inputField, BorderLayout.SOUTH);

		inputField.add(txtField);
		inputField.add(send);

		setVisible(true);
		txtArea.append("Trying to connect to server\r\n");

		memento = new Originator();
		savedStates = new ArrayList<Memento>();
		new Thread(this).start();

		client = new ClientFunctions(msg, savedStates, memento);

		client.openConnection();
		client.getMessageFromServer();

		new Thread(client).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("button1".equals(e.getActionCommand())) {
			client.setSend(txtField.getText());
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			if (msg.clientTextAreaFlagUp()) {
				txtArea.append(msg.getClientTextArea());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38 && memento.getCurrent() > 0) {
			memento.setCurrent(memento.getCurrent() - 1);
			txtField.setText(savedStates.get(memento.getCurrent()).getSavedState());
		}
		if (e.getKeyCode() == 40 && memento.getCurrent() < savedStates.size() - 1) {
			memento.setCurrent(memento.getCurrent() + 1);
			txtField.setText(savedStates.get(memento.getCurrent()).getSavedState());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}