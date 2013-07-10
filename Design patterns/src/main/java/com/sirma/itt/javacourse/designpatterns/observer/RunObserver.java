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
		Products products = new Products();
		StockListener stock = new StockListener();
		products.registerObserver(stock);
		products.addProduct("waffle");
		products.sellProduct("waffle");
	}
}
