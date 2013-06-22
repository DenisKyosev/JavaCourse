package com.sirma.itt.javacourse.netAndGui.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Listeners for the buttons and actions attached.
 */
public class Listeners extends CalculatorWindow implements ActionListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -3625404054087430237L;
	private final JTextField field;
	private int operation;
	private double num2;
	private double num1;
	private final CalculatorFunctions function = new CalculatorFunctions();
	private final JButton[] buttons;

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
		String cmd = e.getActionCommand();
		if (function.isNumber(cmd)) {
			if ("0".equals(field.getText())) {
				field.setText(cmd);
			} else {
				field.setText(field.getText() + cmd);
			}
			num2 = Double.parseDouble(field.getText());
		}
		if (!"0".equals(field.getText()) && !field.getText().isEmpty()) {
			if ("+".equals(cmd)) {
				num1 = Double.parseDouble(field.getText());
				field.setText("0");
				operation = 1;
			} else if ("-".equals(cmd)) {
				num1 = Double.parseDouble(field.getText());
				field.setText("0");
				operation = 2;
			} else if ("*".equals(cmd)) {
				num1 = Double.parseDouble(field.getText());
				field.setText("0");
				operation = 3;
			} else if ("/".equals(cmd)) {
				num1 = Double.parseDouble(field.getText());
				field.setText("0");
				operation = 4;
			} else if (".".equals(cmd)) {
				field.setText(function.putDot(field.getText()));
			} else if ("C".equals(cmd)) {
				field.setText(function.deleteDigit(field.getText()));
			} else if ("CC".equals(cmd)) {
				num1 = 0;
				num2 = 0;
				field.setText("0");
			} else if ("=".equals(cmd)) {
				field.setText(function.equal(operation, num1, num2));
				num1 = Double.parseDouble(field.getText());
			}
		}
	}

}
