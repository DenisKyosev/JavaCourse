package com.sirma.itt.javacourse.threads.task7;

/**
 * Run Storage, consumer, producer.
 */
public final class RunStorage {

	/**
	 * Instantiates a new run storage.
	 */
	private RunStorage() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Storage storage = new Storage(1);
		Producer producer = new Producer(2);
		Consumer consumer = new Consumer(1);
		Thread producerThread = new Thread(producer);
		Thread producerThread2 = new Thread(producer);
		Thread producerThread3 = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		Thread consumerThread3 = new Thread(consumer);
		Thread consumerThread2 = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
		producerThread2.start();
		consumerThread2.start();
		producerThread3.start();
		consumerThread3.start();
	}
}
