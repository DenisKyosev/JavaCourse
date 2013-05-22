package com.sirma.itt.javacourse.intro;

/**
 * run class for random string generator.
 * 
 * @author Fester
 */
public final class RunRandomString {
	private static RandomString rs = new RandomString();

	/**
	 * constructor.
	 */
	private RunRandomString() {

	}

	/**
	 * @param args
	 *            no args
	 */
	public static void main(String[] args) {
		int x = 10;

		System.out.println(rs.randomString(x));

	}

}
