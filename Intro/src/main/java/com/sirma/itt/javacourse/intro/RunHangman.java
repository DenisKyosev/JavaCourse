package com.sirma.itt.javacourse.intro;

/**
 * run class for hangman.
 * 
 * @author Fester
 */
public final class RunHangman {
	private static Hangman hang = new Hangman();

	/**
	 * constructor.
	 */
	private RunHangman() {

	}

	/**
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {

		String word = "4u6ki";
		hang.hangmanMain(word);
	}

}
