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
		Sold sold = new Sold();
		InStock stock = new InStock(1, "waffle");
		stock.registerObserver(sold);
		stock.sellProduct(new Product(1, "waffle"));
	}
}
