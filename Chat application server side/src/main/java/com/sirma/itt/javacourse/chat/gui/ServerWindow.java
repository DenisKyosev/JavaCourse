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
import com.sirma.itt.javacourse.chat.serverfunctions.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerWindow.
 */
public class ServerWindow extends JFrame implements ActionListener, Runnable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5337006522417402554L;

	/** The output area. */
	private JTextArea outputArea = new JTextArea();

	/** The edit settings menu item. */
	private final JMenuItem editConfig = new JMenuItem();

	/** The wrapper. */
	private final Wrapper wrap;

	/** The start menu item. */
	private final JMenuItem start = new JMenuItem();

	/** The stop menu item. */
	private final JMenuItem stop = new JMenuItem();

	/** The languages menu. */
	private final JMenu langs = new JMenu();

	/** The users list. */
	private JList<String> usersList = new JList<>();

	/** The server control menu. */
	private final JMenu serverControl = new JMenu();

	/** The bulgarian menu item. */
	private final JMenuItem bulgarian = new JMenuItem();

	/** The english menu item. */
	private final JMenuItem english = new JMenuItem();

	/** The users. */
	private final DefaultListModel<String> users;

	/**
	 * Instantiates a new server window.
	 */
	ServerWindow() {
		wrap = new Wrapper();
		new Settings();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 800, 600);
		Container mainPanel = getContentPane();
		JPanel panel = new JPanel();
		mainPanel.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		outputArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(outputArea);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.9;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 5;
		DefaultCaret caret = (DefaultCaret) outputArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroll, c);
		outputArea.setFocusable(false);

		users = new DefaultListModel<String>();
		usersList = new JList<String>(users);
		JScrollPane scrollList = new JScrollPane(usersList);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 5;
		c.weightx = 0.0001;
		c.weighty = 0.5;
		c.gridy = 1;
		c.gridwidth = 1;
		panel.add(scrollList, c);
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
		c.weighty = 0.02;
		c.weightx = 0.05;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;
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
			new ServerSettingsWindow();
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
				String message = wrap.getMsg().getUpdatedText("Main area");
				outputArea.append(message);
				wrap.getLog().log(message);
			}

			if (wrap.getMsg().getComponentsFlags("logout user")) {
				String usernames = wrap.getMsg().getUpdatedText("logout user");
				if (usernames.contains("::")) {
					String[] usersSplit = usernames.split("::");
					for (int i = 0; i < usersSplit.length; i++) {
						users.removeElement(usersSplit[i].trim());
					}
				} else {
					users.removeElement(usernames.trim());
				}
			}

			if (wrap.getMsg().getComponentsFlags("new user")) {
				String usernames = wrap.getMsg().getUpdatedText("new user");
				if (usernames.contains("::")) {
					String[] usersSplit = usernames.split("::");
					for (int i = 0; i < usersSplit.length; i++) {
						users.addElement(usersSplit[i].trim());
						wrap.getMsg().setTextToBeUpdated("Main area",
								wrap.getLang().getValue("userAddedToList") + usersSplit[i].trim());
					}
				} else {
					users.addElement(usernames.trim());
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("userAddedToList") + usernames.trim());
				}

			}
		}
	}

	/**
	 * Language changed.
	 */
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
