package com.sirma.itt.javacourse.netAndGui.task2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * File downloader with source, destination and progress bar.
 */
public class DownloaderWindow extends JFrame implements ActionListener, Runnable {

	/**
	 * ID.
	 */
	private static final long serialVersionUID = 1L;
	/** The source text field. */
	private final JTextField source;

	/** The destination text field. */
	private final JTextField destination;

	/** The error field. */
	private final JTextField errorField;

	/** The download button. */
	private final JButton download;

	/** The progress. */
	private final JProgressBar progress;

	private final Messenger msg = new Messenger();

	/**
	 * Instantiates a new downloader window.
	 */
	DownloaderWindow() {
		Container mainPanel;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		mainPanel = getContentPane();

		mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

		source = new JTextField("Enter source");
		destination = new JTextField("Enter destination");

		mainPanel.add(source, BorderLayout.PAGE_START);
		mainPanel.add(destination, BorderLayout.LINE_END);

		download = new JButton("Download");

		mainPanel.add(download, BorderLayout.CENTER);
		errorField = new JTextField();
		errorField.setFocusable(false);
		errorField.setBackground(Color.GREEN);

		mainPanel.add(errorField, BorderLayout.LINE_END);
		progress = new JProgressBar();
		progress.setValue(0);
		progress.setStringPainted(true);
		mainPanel.add(progress, BorderLayout.SOUTH);
		download.addActionListener(this);

		setVisible(true);

		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Download".equals(e.getActionCommand())) {
			Thread download = new Thread(new Download(source.getText(), destination.getText(), msg));
			download.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			if (progress.getMaximum() == 100 && msg.progressFlagUp()) {
				progress.setMaximum(msg.getMaxProgressValue());
			}
			if (msg.progressFlagUp()) {
				progress.setValue(msg.getProgressValue());
			}
			if (msg.isUpdatedClient()) {
				errorField.setText(msg.getErrorMessage());
			}
		}
	}
}
