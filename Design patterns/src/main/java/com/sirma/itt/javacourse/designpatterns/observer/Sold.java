package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * sold products.
 */
public class Sold implements Observer {

	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 * 
	 * @param products
	 *            the new products
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/** The products. */

	private ArrayList<Product> products = new ArrayList<Product>();

	/**
	 * Update.
	 * 
	 * @param list
	 *            list of products
	 * @Override
	 */
	public void update(ArrayList<Product> list) {
		this.products = list;
		System.out.println("Sold products list updated. " + list.toString() + " was sold.");
	}

}
