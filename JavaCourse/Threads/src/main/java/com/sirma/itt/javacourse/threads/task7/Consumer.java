package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * if there are products in the storage gets a product. If there are no products waits for product
 * and checks after defined time.
 */
public class Consumer extends Thread {

	/** The time interval to check for products. */
	private int timeStep = 0;

	/**
	 * Instantiates a new consumer.
	 * 
	 * @param timeStep
	 *            the time step
	 */
	Consumer(int timeStep) {
		this.timeStep = timeStep;
	}

	/**
	 * Gets a product.
	 */
	private void getProduct() {
		Storage.getProducts()[Storage.getAvailable()] = null;
		Storage.setAvailable(Storage.getAvailable() - 1);
	}

	/**
	 * if there are products in the storage gets a product. If there are no products waits for
	 * product and checks after defined time.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sleep(timeStep);
			} catch (InterruptedException e1) {
			}
			synchronized (Storage.getProducts()) {
				if (Storage.getAvailable() > 0) {
					getProduct();
					System.out.println("got a product");
					Storage.getProducts().notifyAll();
				} else {
					System.out.println("storage empty waiting for producer");
					try {
						Storage.getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
