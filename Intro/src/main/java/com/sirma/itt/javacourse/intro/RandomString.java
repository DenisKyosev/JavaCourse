package com.sirma.itt.javacourse.intro;

/**
 * random string generator.
 * 
 * @author Fester
 */
public class RandomString {

	/**
	 * random string generator.
	 * 
	 * @param length
	 *            length of the string to be generated
	 * @return random string
	 */
	public String randomString(int length) {
		int charNumber;
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int strLen = str.length();
		String res = "";
		for (int i = 0; i < length; i++) {
			charNumber = (int) (Math.random() * strLen);
			res += str.charAt(charNumber);
		}
		return res;
	}

}
