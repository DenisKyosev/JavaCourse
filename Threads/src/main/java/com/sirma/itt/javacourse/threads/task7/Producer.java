package com.sirma.itt.javacourse.threads.task7;

// TODO: Auto-generated Javadoc
/**
 * if there is room in the storage produces new product. If there's no room waits for customers to
 * get some products.
 */
public class Producer implements Runnable {

	/** The time interval to add new product in the storage. */
	private int timeStep = 0;

	/** The storage. */
	private final Storage storage;

	/**
	 * Instantiates a new producer.
	 * 
	 * @param timeStep
	 *            the time step
	 * @param storage
	 *            the storage
	 */
	Producer(int timeStep, Storage storage) {
		this.storage = storage;
		storage.getCapacity();
		this.timeStep = timeStep;
	}

	/**
	 * Produce.
	 */
	private void produce() {
		storage.getProducts()[storage.getAvailable()] = new Object();
		storage.setAvailable(storage.getAvailable() + 1);
	}

	/**
	 * if there is room in the storage produces new product. If there's no room waits for customers
	 * to get some products.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(timeStep);
			} catch (InterruptedException e1) {
			}
			synchronized (storage.getProducts()) {
				if (storage.getAvailable() < storage.getCapacity()) {
					produce();
					System.out.println("new product made");
					storage.getProducts().notifyAll();
				} else {
					System.out.println("storage full waiting for consumer");
					try {
						storage.getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
