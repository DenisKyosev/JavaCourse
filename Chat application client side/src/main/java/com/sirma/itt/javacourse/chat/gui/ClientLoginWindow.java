package com.sirma.itt.javacourse.chat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.clientfunctions.Settings;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientLoginWindow.
 */
public class ClientLoginWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 9187415098397371455L;

	/** The host. */
	private final JTextField host;

	/** The port. */
	private final JTextField port;

	/** The username. */
	private final JTextField username;

	/** The connect button. */
	private final JButton connect;

	/** The cancel button. */
	private final JButton cancel;

	/** The wrapper. */
	private final Wrapper wrap;

	/** The function. */
	private final Settings function = new Settings();

	/**
	 * Instantiates a new client login window.
	 * 
	 * @param wrap
	 *            the wrapper
	 */
	ClientLoginWindow(Wrapper wrap) {
		this.wrap = wrap;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500, 500, 300, 150);
		Container mainPanel = getContentPane();

		JPanel editField = new JPanel(new GridLayout(4, 2));
		host = new JTextField("localhost");
		port = new JTextField("7000");
		username = new JTextField();
		connect = new JButton(wrap.getLang().getValue("connect"));
		cancel = new JButton(wrap.getLang().getValue("cancel"));

		editField.add(new JLabel(wrap.getLang().getValue("host")));
		editField.add(host);

		editField.add(new JLabel(wrap.getLang().getValue("port")));
		editField.add(port);

		editField.add(new JLabel(wrap.getLang().getValue("username")));
		editField.add(username);

		editField.add(cancel);
		editField.add(connect);
		connect.addActionListener(this);
		cancel.addActionListener(this);

		editField.setBorder(BorderFactory.createTitledBorder(wrap.getLang().getValue("login")));

		mainPanel.setBackground(Color.GREEN);
		mainPanel.add(editField, BorderLayout.CENTER);
		getSettings();

		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			try {
				wrap.getConnector().connect(host.getText(), Integer.parseInt(port.getText()),
						username.getText());
				function.saveSettings(host.getText(), port.getText(), username.getText());
				dispose();
			} catch (NumberFormatException e2) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("wrongPortError"));
			}

		}
		if (e.getSource() == cancel) {
			dispose();
		}
	}

	/**
	 * Gets last used settings.
	 */
	private void getSettings() {
		host.setText(function.getSettings("host"));
		port.setText(function.getSettings("port"));
		username.setText(function.getSettings("lastUsedUsername"));
	}
}
