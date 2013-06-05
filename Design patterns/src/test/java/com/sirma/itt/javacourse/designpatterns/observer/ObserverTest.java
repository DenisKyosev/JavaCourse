package com.sirma.itt.javacourse.designpatterns.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ObserverTest.
 */
public class ObserverTest {

	/**
	 * Observer add in stock.
	 */
	@Test
	public void observerAddInStock() {
		Sold sold = new Sold();
		InStock stock = new InStock(1, "waffle");
		Product product = new Product(1, "waffle");

		stock.registerObserver(sold);
		assertEquals("[]", sold.getProducts().toString());

		stock.sellProduct(product);
		assertEquals("waffle", sold.getProducts().get(0).getName().toString());
	}
}
