package com.sirma.itt.javacourse.chat.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;

import com.sirma.itt.javacourse.chat.controllers.Wrapper;

public class ServerWindow extends JFrame implements ActionListener, Runnable {
	JTextArea txtArea = new JTextArea();
	JMenuItem editConfig = new JMenuItem();
	Wrapper wrap;
	boolean closed = false;
	JMenuItem start = new JMenuItem();
	JMenuItem stop = new JMenuItem();
	JMenu langs = new JMenu();
	JList usersList = new JList<>();
	JMenu serverControl = new JMenu();
	JMenuItem bulgarian = new JMenuItem();
	JMenuItem english = new JMenuItem();
	DefaultListModel<String> users;

	ServerWindow() {
		wrap = new Wrapper();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 700, 600);
		Container mainPanel = getContentPane();
		JPanel panel = new JPanel();
		mainPanel.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		txtArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtArea);
		c.fill = GridBagConstraints.BOTH;
		// c.ipadx = 300;
		c.weightx = 0.9;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 5;
		DefaultCaret caret = (DefaultCaret) txtArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroll, c);
		txtArea.setFocusable(false);

		users = new DefaultListModel<String>();
		usersList = new JList(users);
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 150;
		c.gridx = 5;
		c.weightx = 0.0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel.add(usersList, c);
		wrap.getMsg().newComponent("new user");
		wrap.getMsg().newComponent("logout user");

		JMenuBar menuBar = new JMenuBar();

		menuBar.add(serverControl);
		serverControl.setMnemonic(KeyEvent.VK_S);
		stop.setEnabled(false);
		stop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		stop.addActionListener(this);
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		start.addActionListener(this);
		serverControl.add(start);
		serverControl.add(stop);
		c.ipady = 5;
		c.weighty = 0.01;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(menuBar, c);

		serverControl.add(editConfig);
		editConfig.addActionListener(this);
		editConfig.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

		langs.setMnemonic(KeyEvent.VK_L);

		bulgarian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		english.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

		bulgarian.addActionListener(this);
		english.addActionListener(this);

		langs.add(bulgarian);
		langs.add(english);
		menuBar.add(langs);

		languageChanged();

		setVisible(true);

		wrap.getMsg().newComponent("Main area");
		wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("serverLaunched"));

		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editConfig) {
			new ServerSettings();
		}
		if (e.getSource() == start || e.getSource() == stop) {
			if (wrap.getServer() == null) {
				wrap.connect();
				start.setEnabled(false);
				stop.setEnabled(true);
			} else {
				stop.setEnabled(false);
				wrap.disconnect();
				start.setEnabled(true);
			}
		}
		if (e.getSource() == bulgarian) {
			wrap.getLang().setLanguage("bulgarian");
			languageChanged();
		} else if (e.getSource() == english) {
			wrap.getLang().setLanguage("english");
			languageChanged();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (wrap.getMsg().getComponentsFlags("Main area")) {
				txtArea.append(wrap.getMsg().getUpdatedText("Main area"));
			}
			if (wrap.getMsg().getComponentsFlags("logout user")) {
				users.removeElement(wrap.getMsg().getUpdatedText("logout user"));
			}
			if (wrap.getMsg().getComponentsFlags("new user")) {
				users.addElement(wrap.getMsg().getUpdatedText("new user"));
			}
		}
	}

	private void languageChanged() {
		usersList.setBorder(BorderFactory
				.createTitledBorder(wrap.getLang().getValue("onlineUsers")));
		serverControl.setText(wrap.getLang().getValue("serverControl"));
		stop.setText(wrap.getLang().getValue("stopServer"));
		start.setText(wrap.getLang().getValue("startServer"));
		bulgarian.setText(wrap.getLang().getValue("bulgarian"));
		english.setText(wrap.getLang().getValue("english"));
		editConfig.setText(wrap.getLang().getValue("settings"));
		langs.setText(wrap.getLang().getValue("languages"));
	}
}
