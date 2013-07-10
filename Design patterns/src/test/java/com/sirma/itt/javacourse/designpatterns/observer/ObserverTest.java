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
		Products products = new Products();
		StockListener stock = new StockListener();

		assertEquals(0, products.getObservers().size());

		products.registerObserver(stock);
		products.addProduct("waffle");

		assertEquals(true, stock.isUpdated());

		assertNotEquals(null, products.getObservers().get(0));
		assertEquals(1, products.getObservers().size());
	}
}
