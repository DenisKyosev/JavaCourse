package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * if there are products in the storage gets a product. If there are no products waits for product
 * and checks after defined time.
 */
public class Consumer implements Runnable {

	/** The time interval to check for products. */
	private int timeStep = 0;

	/** The storage. */
	private final Storage storage;

	/**
	 * Instantiates a new consumer.
	 * 
	 * @param timeStep
	 *            the time step
	 * @param storage
	 *            the storage
	 */
	Consumer(int timeStep, Storage storage) {
		this.storage = storage;
		storage.getCapacity();
		this.timeStep = timeStep;
	}

	/**
	 * Gets a product.
	 */
	private void getProduct() {
		storage.getProducts()[storage.getAvailable() - 1] = null;
		storage.setAvailable(storage.getAvailable() - 1);
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
			synchronized (storage.getProducts()) {
				if (storage.getAvailable() > 0) {
					System.out.println("got a product");
					getProduct();
					storage.getProducts().notifyAll();
				} else {
					System.out.println("storage empty waiting for producer");
					try {
						storage.getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
