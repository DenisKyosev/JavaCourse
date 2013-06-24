package com.sirma.itt.javacourse.netAndGui.task1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculatorWindow.
 */
public class CalculatorWindow extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The input field. */
	private final JPanel inputField;

	/**
	 * Gets the input field.
	 * 
	 * @return the input field
	 */
	protected JPanel getInputField() {
		return inputField;
	}

	/**
	 * Gets the control panel.
	 * 
	 * @return the control
	 */
	protected JPanel getControl() {
		return control;
	}

	/** The control panel. */
	private final JPanel control;

	/**
	 * Instantiates a new calculator window.
	 */
	CalculatorWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		Container mainPanel = getContentPane();

		inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainPanel.add(inputField, BorderLayout.PAGE_START);

		control = new JPanel(new GridLayout(0, 5, 10, 10));
		control.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainPanel.add(control);
		setVisible(true);
	}
}
