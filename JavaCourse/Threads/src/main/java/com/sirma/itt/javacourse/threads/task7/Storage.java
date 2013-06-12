package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * The Class Storage.
 */
public class Storage {

	/** The capacity. */
	private int capacity = 0;

	/** The available products. */
	private int available = 0;

	/** all products. */
	private Object[] products;

	/**
	 * Gets the capacity.
	 * 
	 * @return the capacity
	 */
	protected int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity.
	 * 
	 * @param capacity
	 *            the new capacity
	 */
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Gets the available products.
	 * 
	 * @return the available products
	 */
	protected int getAvailable() {
		return available;
	}

	/**
	 * Sets the available products.
	 * 
	 * @param available
	 *            the new available products
	 */
	protected void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	protected Object[] getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 * 
	 * @param products
	 *            the new products
	 */
	protected void setProducts(Object[] products) {
		this.products = products;
	}

	/**
	 * Instantiates a new storage.
	 * 
	 * @param capacity
	 *            the capacity
	 */
	protected Storage(int capacity) {
		this.capacity = capacity;
		this.products = new Object[capacity];
	}

}
