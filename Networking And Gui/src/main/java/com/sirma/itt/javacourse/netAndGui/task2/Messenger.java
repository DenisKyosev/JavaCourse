package com.sirma.itt.javacourse.netAndGui.task2;

// TODO: Auto-generated Javadoc
/**
 * UI - Functions connection (controller).
 */
public class Messenger {

	/** The new error message. */
	private String errorMessage = "";

	/** Client updated flag. */
	private boolean updatedClient = false;

	/** The progress flag. */
	private boolean progressFlag = false;

	/** The progress value. */
	private int progressValue = 0;

	/** The max progress value. */
	private int maxProgressValue;

	/**
	 * Gets the max progress value.
	 * 
	 * @return the max progress value
	 */
	protected int getMaxProgressValue() {
		progressFlag = false;
		return maxProgressValue;
	}

	/**
	 * Sets the max progress value.
	 * 
	 * @param maxProgressValue
	 *            the new max progress value
	 */
	protected void setMaxProgressValue(int maxProgressValue) {
		progressFlag = true;
		this.maxProgressValue = maxProgressValue;
	}

	/**
	 * Progress change flag up.
	 * 
	 * @return true, if successful
	 */
	protected boolean progressFlagUp() {
		return progressFlag;
	}

	/**
	 * Gets the progress value.
	 * 
	 * @return the progress value
	 */
	protected int getProgressValue() {
		progressFlag = false;
		return progressValue;
	}

	/**
	 * Sets the progress value.
	 * 
	 * @param progressValue
	 *            the new progress value
	 */
	protected void setProgressValue(int progressValue) {
		progressFlag = true;
		this.progressValue = progressValue;
	}

	/**
	 * Gets the client message.
	 * 
	 * @return the client message
	 */
	protected String getErrorMessage() {
		updatedClient = false;
		return errorMessage;
	}

	/**
	 * Sets the new error message.
	 * 
	 * @param errorMessage
	 *            the new error
	 */
	protected void setErrorMessage(String errorMessage) {
		updatedClient = true;
		this.errorMessage = errorMessage;
	}

	/**
	 * Checks if is updated client.
	 * 
	 * @return true, if is updated client
	 */
	protected boolean isUpdatedClient() {
		return updatedClient;
	}

}
