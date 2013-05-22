package com.sirma.itt.javacourse.collections;

// TODO: Auto-generated Javadoc
/**
 * Run Class for ExcepnionsMessageManager.
 */
public final class RunExcepnionsMessageManager {

	/**
	 * Instantiates a new run excepnions message manager.
	 */
	private RunExcepnionsMessageManager() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ExceptionsMessageManager exc = new ExceptionsMessageManager();
		String testMsg = "hey|sup|omg";
		System.out.println(exc.getMessages(testMsg).toArray().toString());
		try {
			exc.addExceptionMessage("hello");
			exc.addExceptionMessageUsingCode("buu");
			System.out.println(exc.getExceptions());
			System.out.println(exc.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
