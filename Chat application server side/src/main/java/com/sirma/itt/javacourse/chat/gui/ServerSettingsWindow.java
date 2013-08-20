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

import com.sirma.itt.javacourse.chat.serverfunctions.Settings;

// TODO: Auto-generated Javadoc
/**
 * Server Settings Window.
 */
public class ServerSettingsWindow extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -5682727138147980248L;

	/** The host. */
	private final JTextField host;

	/** The min port. */
	private final JTextField minPort;

	/** The max port. */
	private final JTextField maxPort;

	/** The save. */
	private final JButton save;

	/** The cancel. */
	private final JButton cancel;

	/** The function. */
	private final Settings function = new Settings();

	/**
	 * Instantiates a new server settings window.
	 */
	ServerSettingsWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 200, 300, 150);
		Container mainPanel = getContentPane();

		JPanel editField = new JPanel(new GridLayout(4, 2));
		host = new JTextField();
		minPort = new JTextField();
		maxPort = new JTextField();
		save = new JButton("Save");
		cancel = new JButton("Cancel");

		editField.add(new JLabel("Host:"));
		editField.add(host);

		editField.add(new JLabel("Minimum port:"));
		editField.add(minPort);

		editField.add(new JLabel("Maximum port:"));
		editField.add(maxPort);

		editField.add(cancel);
		editField.add(save);
		save.addActionListener(this);
		cancel.addActionListener(this);

		editField.setBorder(BorderFactory.createTitledBorder("Settings"));

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
		if (e.getSource() == save) {
			function.saveSettings(host.getText(), minPort.getText(), maxPort.getText());
		}
		if (e.getSource() == cancel) {
			dispose();
		}
	}

	/**
	 * Gets the last used settings settings.
	 */
	private void getSettings() {
		host.setText(function.getSettings("host"));
		minPort.setText(function.getSettings("minPort"));
		maxPort.setText(function.getSettings("maxPort"));
	}
}
