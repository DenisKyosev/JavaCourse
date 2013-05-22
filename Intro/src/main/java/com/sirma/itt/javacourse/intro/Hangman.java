package com.sirma.itt.javacourse.intro;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * hangman game.
 * 
 * @author Fester
 */
public class Hangman {

	/**
	 * reading data from console.
	 * 
	 * @return line
	 */
	protected String read() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		try {
			line = br.readLine();
		} catch (Exception e) {
		}
		return line;
	}

	/**
	 * checks if a character is contained in the word.
	 * 
	 * @param userStr
	 *            user's word
	 * @param realStr
	 *            word to be quessed
	 * @param ch
	 *            character inserted
	 * @return new user word
	 */
	protected StringBuilder checkChar(StringBuilder userStr, String realStr, char ch) {
		String realWord = realStr;
		StringBuilder userWord = userStr;
		int wordLen = realWord.length();
		char letter = ch;
		for (int i = 0; i < wordLen; i++) {
			if (realWord.charAt(i) == letter) {
				userWord.setCharAt(i, letter);
			}
		}
		return userWord;
	}

	/**
	 * @param realStr
	 *            word to be quessed
	 */
	public void hangmanMain(String realStr) {
		if (realStr == null || realStr.length() == 0) {
			throw new IllegalArgumentException();
		}

		String realWord = realStr;
		int length = realWord.length();
		StringBuilder userWord = new StringBuilder();
		StringBuilder oldUserWord = new StringBuilder();
		String ch;
		char[] letter;
		int mistakes = 0;
		int maxMistakes = length / 2;

		for (int i = 0; i < length; i++) {
			userWord.append("_");
			oldUserWord.append("_");
		}
		while (userWord.toString().contains("_")) {
			ch = read();

			letter = ch.toCharArray();

			userWord = checkChar(userWord, realWord, letter[0]);

			if (oldUserWord.toString().equals(userWord.toString())
					&& oldUserWord.indexOf(Character.toString(letter[0])) == -1) {
				mistakes++;
				System.out.print("Mistake! " + (maxMistakes - mistakes) + " more lives \n");
				oldUserWord = checkChar(userWord, realWord, letter[0]);
			} else {
				oldUserWord = checkChar(userWord, realWord, letter[0]);
			}
			if (mistakes >= maxMistakes) {
				System.out.println("You're dead! \n");
				break;
			} else {
				System.out.println(userWord);
			}
		}
	}
}
