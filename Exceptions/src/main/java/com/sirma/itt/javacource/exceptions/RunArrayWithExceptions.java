package com.sirma.itt.javacource.exceptions;

// TODO: Auto-generated Javadoc
/**
 * run class for ArrayWithExceptions.
 */
public final class RunArrayWithExceptions {
	/**
	 * constructor.
	 */
	private RunArrayWithExceptions() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		ArrayWithExceptions arr = new ArrayWithExceptions(4);

		try {
			arr.add(new Object());
			arr.add(new Object());
			arr.add(new Object());

		} catch (ArrayIsFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			arr.remove();
			arr.remove();

		} catch (ArrayIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(arr.allElements());
		} catch (ArrayIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
