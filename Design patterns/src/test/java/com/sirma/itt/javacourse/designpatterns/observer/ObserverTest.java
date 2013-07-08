package com.sirma.itt.javacourse.designpatterns.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		InStock inStock = new InStock();
		StockListener stock = new StockListener();

		assertEquals(0, inStock.getObservers().size());

		inStock.registerObserver(stock);
		inStock.addProduct("waffle");

		assertEquals(false, stock.isUpdated());

		inStock.notifyObservers();
		assertEquals(true, stock.isUpdated());

		assertNotEquals(null, inStock.getObservers().get(0));
		assertEquals(1, inStock.getObservers().size());
	}
}
