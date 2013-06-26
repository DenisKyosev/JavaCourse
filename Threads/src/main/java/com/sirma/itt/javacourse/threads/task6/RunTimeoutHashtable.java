package com.sirma.itt.javacourse.threads.task6;

// TODO: Auto-generated Javadoc
/**
 * Run class for timeout hashtable.
 */
public final class RunTimeoutHashtable {

	/**
	 * Instantiates a new run timeout hash table.
	 */
	private RunTimeoutHashtable() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		MyTable hash = new MyTable(7000, 1000);
		Thread hashCheck = new Thread(hash);
		hashCheck.start();
		hash.put("hello", "wooo");
		hash.put("wazzaaa", "wooo");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
				if (i % 2 == 0) {
					hash.get("hello");
				} else {
					hash.put("asd", "valueee");
				}
			} catch (InterruptedException e) {
			}
		}
		System.out.println(hash.get("end"));
	}

}
