package com.sirma.itt.javacourse.threads.task7;

/**
 * if there is room in the storage produces new product. If there's no room waits for customers to
 * get some products.
 */
public class Producer extends Thread {

	/** The time interval to add new product in the storage. */
	private int timeStep = 0;

	/**
	 * Instantiates a new producer.
	 * 
	 * @param timeStep
	 *            the time step
	 */
	Producer(int timeStep) {
		this.timeStep = timeStep;
	}

	/**
	 * Produce.
	 */
	private void produce() {
		Storage.getProducts()[Storage.getAvailable()] = new Object();
		Storage.setAvailable(Storage.getAvailable() + 1);
	}

	/**
	 * if there is room in the storage produces new product. If there's no room waits for customers
	 * to get some products.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sleep(timeStep);
			} catch (InterruptedException e1) {
			}
			synchronized (Storage.getProducts()) {
				if (Storage.getAvailable() < Storage.getCapacity() - 1) {
					produce();
					System.out.println("new product made");
					Storage.getProducts().notifyAll();
				} else {
					System.out.println("storage full waiting for consumer");
					try {
						Storage.getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
