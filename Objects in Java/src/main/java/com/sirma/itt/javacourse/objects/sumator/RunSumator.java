package com.sirma.itt.javacourse.objects.sumator;

/**
 * run class for sumator.
 * 
 * @author Fester
 */
public final class RunSumator {
	private static Sumator sm = new Sumator();

	/**
	 * constructor.
	 */
	private RunSumator() {

	}

	/**
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {

		System.out.println(sm.sum(5, 5));

	}

}
