package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * Run class for observer task.
 */
public final class RunObserver {

	/**
	 * Run class for observer task.
	 */
	private RunObserver() {

	}

	/**
	 * main.
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		InStock inStock = new InStock();
		StockListener stock = new StockListener();
		inStock.registerObserver(stock);
		inStock.addProduct("waffle");
		inStock.notifyObservers();
	}
}
