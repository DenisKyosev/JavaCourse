package com.sirma.itt.javacourse.threads.task7;

/**
 * if there is room in the storage produces new product. If there's no room waits for customers to
 * get some products.
 */
public class Producer extends Storage implements Runnable {

	/** The time interval to add new product in the storage. */
	private int timeStep = 0;

	/**
	 * Instantiates a new producer.
	 * 
	 * @param timeStep
	 *            the time step
	 */
	Producer(int timeStep) {
		super(getCapacity());
		this.timeStep = timeStep;
	}

	/**
	 * Produce.
	 */
	private void produce() {
		getProducts()[getAvailable()] = new Object();
		setAvailable(getAvailable() + 1);
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
			synchronized (getProducts()) {
				if (getAvailable() < getCapacity()) {
					produce();
					System.out.println("new product made");
					getProducts().notifyAll();
				} else {
					System.out.println("storage full waiting for consumer");
					try {
						getProducts().wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
