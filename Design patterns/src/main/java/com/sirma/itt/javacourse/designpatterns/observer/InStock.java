package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;

/**
 * Products in stock.
 */
public class InStock implements Subject {

	/**
	 * Instantiates a new list with products in stock.
	 * 
	 * @param id
	 *            the id of the product
	 * @param name
	 *            the name of the product
	 */
	InStock(int id, String name) {
		this.products.add(new Product(id, name));
	}

	/** The products. */
	private final ArrayList<Product> products = new ArrayList<Product>();

	/** The observers. */
	private final ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * @Override
	 * @param observer
	 *            observer
	 */
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	/**
	 * @Override
	 * @param observer
	 *            observer
	 */
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * @Override
	 */
	public void notifyObservers() {
		for (Observer ob : observers) {
			System.out.println("Notifying Observers on change in products");
			ob.update(this.products);
		}
	}

	/**
	 * Adds the product.
	 * 
	 * @param product
	 *            the product
	 */
	public void addProduct(Product product) {
		products.add(product);

	}

	/**
	 * Sell product and notify observers.
	 * 
	 * @param product
	 *            the product
	 */
	public void sellProduct(Product product) {
		products.remove(product);
		notifyObservers();
	}

}
