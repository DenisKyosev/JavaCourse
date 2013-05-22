package com.sirma.itt.javacourse.reflections.regex;

/**
 * The Class RunIbanValidator.
 */
public final class RunIbanValidator {

	/**
	 * Instantiates a new run iban validator.
	 */
	private RunIbanValidator() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		IbanValidator validate = new IbanValidator();
		String ibans = "<bankAccounts>" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>"
				+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>"
				+ "<iban>SA80 8000 0375 6080 1019 0160</iban>"
				+ "<iban>CH51 0868 6001 2565 1500 1</iban>"
				+ "<iban>BG80 BNBG 9661 1020 3456 7840</iban>"
				+ "<iban>IL30 01BG 0300 0009 6339 234</iban>"
				+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>"
				+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>"
				+ "<iban>BG80 BNBG 9661 1020 3456 7843</iban>" + "</bankAccounts>";
		System.out.print(validate.validate(ibans));
	}

}
