package com.sirma.itt.javacourse.threads.task6;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * hash table with thread checking for changes in the table every second if there are no changes for
 * x seconds the element is removed from the table.
 */
public class MyTable implements Runnable {

	/** The hash table with objects. */
	private final Hashtable<String, Object> hash = new Hashtable<String, Object>();

	/** The times table. */
	private final Hashtable<String, Integer> time = new Hashtable<String, Integer>();

	/** The max life time. */
	private int life = 1000;

	/** The time step. */
	private int lifeStep = 1000;

	/** The current life. */
	private int currentLife = 0;

	/**
	 * Instantiates a new table.
	 * 
	 * @param life
	 *            maximum life time
	 * @param lifeStep
	 *            time step
	 */
	MyTable(int life, int lifeStep) {
		this.life = life;
		this.lifeStep = lifeStep;
	}

	/**
	 * Puts element in the table.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(String key, Object value) {
		hash.put(key, value);
		time.put(key, 0);
	}

	/**
	 * Gets the element from the table.
	 * 
	 * @param key
	 *            the key
	 * @return the object
	 */
	public Object get(String key) {
		time.put(key, 0);
		return hash.get(key);
	}

	/**
	 * run thread.
	 */
	public void run() {
		while (true) {
			while (currentLife <= life) {
				try {
					Thread.sleep(lifeStep);
				} catch (InterruptedException e) {
				}
				Enumeration<String> keys = hash.keys();
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					if (time.get(key) > life) {
						hash.remove(key);
						time.remove(key);
						System.out.println("removed - " + key);
					} else {
						time.put(key, time.get(key) + lifeStep);
						System.out.println("it's ok " + key);
					}
				}
				currentLife += lifeStep;
			}
			currentLife = 0;
		}
	}
}
