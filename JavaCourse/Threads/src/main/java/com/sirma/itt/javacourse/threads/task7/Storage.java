package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * The Class Storage.
 */
public class Storage {

	/** The capacity. */
	private static int capacity = 0;

	/** The available products. */
	private static int available = 0;

	/** all products. */
	private static Object[] products;

	/**
	 * Gets the capacity.
	 * 
	 * @return the capacity
	 */
	protected static int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity.
	 * 
	 * @param capacity
	 *            the new capacity
	 */
	protected void setCapacity(int capacity) {
		Storage.capacity = capacity;
	}

	/**
	 * Gets the available products.
	 * 
	 * @return the available products
	 */
	protected static int getAvailable() {
		return available;
	}

	/**
	 * Sets the available products.
	 * 
	 * @param available
	 *            the new available products
	 */
	protected static void setAvailable(int available) {
		Storage.available = available;
	}

	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	protected static Object[] getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 * 
	 * @param products
	 *            the new products
	 */
	protected static void setProducts(Object[] products) {
		Storage.products = products;
	}

	/**
	 * Instantiates a new storage.
	 * 
	 * @param capacity
	 *            the capacity
	 */
	protected Storage(int capacity) {
		Storage.capacity = capacity;
		Storage.products = new Object[capacity];
	}

}
