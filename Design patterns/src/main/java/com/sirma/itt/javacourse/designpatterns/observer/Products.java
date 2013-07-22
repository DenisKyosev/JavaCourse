package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Products.
 */
public class Products {
	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	protected ArrayList<String> getProducts() {
		return products;
	}

	/**
	 * Gets the observers.
	 * 
	 * @return the observers
	 */
	protected ArrayList<Observer> getObservers() {
		return observers;
	}

	/** The products. */
	private final ArrayList<String> products = new ArrayList<String>();

	/** The observers. */
	private final ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * Register observer.
	 * 
	 * @param observer
	 *            observer
	 * @Override
	 */
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	/**
	 * Removes the observer.
	 * 
	 * @param observer
	 *            observer
	 * @Override
	 */
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * Notify observers.
	 * 
	 * @Override
	 */
	public void notifyObservers() {
		for (Observer ob : observers) {
			System.out.println("Notifying Observers on change in products");
			ob.update();
		}
	}

	/**
	 * Adds the product.
	 * 
	 * @param product
	 *            the product
	 */
	public void addProduct(String product) {
		products.add(product);
		notifyObservers();
	}

	/**
	 * Sell product and notify observers.
	 * 
	 * @param product
	 *            the product
	 */
	public void sellProduct(String product) {
		products.remove(product);
		notifyObservers();
	}
}
