package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailBuilder.
 */
public abstract class EmailBuilder {

	/** The mail. */
	private Mail mail;

	/**
	 * Gets the mail.
	 * 
	 * @return the mail
	 */
	public Mail getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 * 
	 * @param mail
	 *            the new mail
	 */
	public void setMail(Mail mail) {
		this.mail = mail;
	}

	/**
	 * From.
	 * 
	 * @param from
	 *            the from
	 * @return the email builder
	 */
	abstract EmailBuilder from(String from);

	/**
	 * To.
	 * 
	 * @param to
	 *            the to
	 * @return the email builder
	 */
	abstract EmailBuilder to(String to);

	/**
	 * Subject.
	 * 
	 * @param subject
	 *            the subject
	 * @return the email builder
	 */
	abstract EmailBuilder subject(String subject);

	/**
	 * Content.
	 * 
	 * @param content
	 *            the content
	 * @return the email builder
	 */
	abstract EmailBuilder content(String content);

	/**
	 * Cc.
	 * 
	 * @param cc
	 *            the cc
	 * @return the email builder
	 */
	abstract EmailBuilder cc(String cc);

	/**
	 * Attachments.
	 * 
	 * @param attachments
	 *            the attachments
	 * @return the email builder
	 */
	abstract EmailBuilder attachments(String[] attachments);
}
