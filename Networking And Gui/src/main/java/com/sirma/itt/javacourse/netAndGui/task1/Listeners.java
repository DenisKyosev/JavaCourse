package com.sirma.itt.javacourse.netAndGui.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * Listeners for the buttons and actions attached.
 */
public class Listeners extends CalculatorWindow implements ActionListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -3625404054087430237L;

	/** The field. */
	private final JTextField field;

	/** The operation. */
	private int operation = 0;

	/** The num2. */
	private double num2 = 0;

	/** The num1. */
	private double num1 = 0;

	/** The function. */
	private final CalculatorFunctions function = new CalculatorFunctions();

	/** The buttons. */
	private final JButton[] buttons;

	/** The cmd. */
	private String cmd = "0";

	/**
	 * Instantiates new listeners.
	 */
	Listeners() {
		buttons = new JButton[18];
		String[] buttonLabels = { "1", "2", "3", "+", "-", "4", "5", "6", "*", "/", "7", "8", "9",
				"C", "CC", "0", ".", "=" };
		for (int i = 0; i < buttons.length; i++) {

			buttons[i] = new JButton(buttonLabels[i]);
			buttons[i].addActionListener(this);
			getControl().add(buttons[i]);
		}
		field = new JTextField();
		field.setText("0");
		field.setFocusable(false);
		getInputField().add(field);
		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		cmd = e.getActionCommand();
		if (function.isNumber(cmd)) {
			if (field.getText().startsWith("0") && ".".equals(cmd)) {
				field.setText(cmd);
			} else if (operation == 0 && !"0".equals(field.getText())) {
				field.setText(field.getText() + cmd);
			} else {
				field.setText(cmd);
			}
			num2 = Double.parseDouble(field.getText());
		}
		if (!field.getText().isEmpty() && !"0".equals(field.getText())) {
			if ("+".equals(cmd)) {
				if (operation != 0) {
					calculate();
				}
				operation = 1;
				num1 = Double.parseDouble(field.getText());
			} else if ("-".equals(cmd)) {
				if (operation != 0) {
					calculate();
				}
				operation = 2;
				num1 = Double.parseDouble(field.getText());
			} else if ("*".equals(cmd)) {
				if (operation != 0) {
					calculate();
				}
				operation = 3;
				num1 = Double.parseDouble(field.getText());
			} else if ("/".equals(cmd)) {
				if (operation != 0) {
					calculate();
				}
				operation = 4;
				num1 = Double.parseDouble(field.getText());
			} else if ("C".equals(cmd)) {
				field.setText(function.deleteDigit(field.getText()));
			} else if ("CC".equals(cmd)) {
				num1 = 0;
				num2 = 0;
				field.setText("0");
			} else if ("=".equals(cmd) && operation != 0) {
				calculate();
				operation = 0;
			}
		}

		if (".".equals(cmd)) {
			field.setText(function.putDot(field.getText()));
		}
	}

	/**
	 * Calculate.
	 */
	void calculate() {
		cmd = function.equal(operation, num1, num2);
		field.setText(cmd);
		num1 = Double.parseDouble(field.getText());
	}
}
