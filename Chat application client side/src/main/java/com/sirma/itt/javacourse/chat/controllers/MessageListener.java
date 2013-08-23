package com.sirma.itt.javacourse.chat.controllers;

// TODO: Auto-generated Javadoc
/**
 * Listening for messages from the server. Forwards the messages to the interested classes. Command
 * messages start with "/". Thread stops when connection is lost.
 */
public class MessageListener implements Runnable {

	/** The stop. */
	private boolean stop = false;

	/** The wrapper. */
	private final Wrapper wrap;

	/**
	 * Instantiates a new message listener.
	 * 
	 * @param wrap
	 *            the wrapper
	 */
	MessageListener(Wrapper wrap) {
		this.wrap = wrap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!stop) {
			String msg = wrap.getMessenger().receive();
			if (msg == null) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("connectionLost"));
				try {
					wrap.getClient().close();
				} catch (Exception e) {
				}
				wrap.setClient(null);
				stop = true;

			} else if (msg.startsWith("/")) {
				wrap.getCmdParser().parseCommand(msg);
			} else {
				wrap.getMsg().setTextToBeUpdated("Main area", msg);
			}
		}
	}
}
