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
public class DownloaderWindow extends JFrame implements ActionListener {

	/**
	 * ID.
	 */
	private static final long serialVersionUID = 1L;
	/** The source text field. */
	private JTextField source;

	/** The destination text field. */
	private JTextField destination;

	/** The error field. */
	private final JTextField errorField;

	/** The download button. */
	private final JButton download;

	/** The main panel. */
	private final Container mainPanel;
	/** The progress. */
	private JProgressBar progress;

	/**
	 * Gets the progress.
	 * 
	 * @return the progress
	 */
	protected JProgressBar getProgress() {
		return progress;
	}

	/**
	 * Sets the progress.
	 * 
	 * @param progress
	 *            the new progress
	 */
	protected void setProgress(JProgressBar progress) {
		this.progress = progress;
	}

	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	protected JTextField getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 * 
	 * @param source
	 *            the new source
	 */
	protected void setSource(JTextField source) {
		this.source = source;
	}

	/**
	 * Gets the destination.
	 * 
	 * @return the destination
	 */
	protected JTextField getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 * 
	 * @param destination
	 *            the new destination
	 */
	protected void setDestination(JTextField destination) {
		this.destination = destination;
	}

	/**
	 * Gets the error field.
	 * 
	 * @return the error field
	 */
	protected JTextField getErrorField() {
		return errorField;
	}

	/**
	 * Instantiates a new downloader window.
	 */
	DownloaderWindow() {
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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread download = new Thread(new Download(this));
		download.start();
	}
}
