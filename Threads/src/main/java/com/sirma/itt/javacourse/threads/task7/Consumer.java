package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * if there are products in the storage gets a product. If there are no products waits for product
 * and checks after defined time.
 */
public class Consumer extends Storage implements Runnable {

	/** The time interval to check for products. */
	private int timeStep = 0;

	/**
	 * Instantiates a new consumer.
	 * 
	 * @param timeStep
	 *            the time step
	 */
	Consumer(int timeStep) {
		super(getCapacity());
		this.timeStep = timeStep;
	}

	/**
	 * Gets a product.
	 */
	private void getProduct() {
		getProducts()[getAvailable() - 1] = null;
		setAvailable(getAvailable() - 1);
	}

	/**
	 * if there are products in the storage gets a product. If there are no products waits for
	 * product and checks after defined time.
	 */
	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(timeStep);
			} catch (InterruptedException e1) {
			}
			synchronized (getProducts()) {
				if (getAvailable() > 0) {
					System.out.println("got a product");
					getProduct();
					getProducts().notifyAll();
				} else {
					System.out.println("storage empty waiting for producer");
					try {
						getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
