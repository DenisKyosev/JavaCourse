package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailControl.
 */
public class MailControl {

	/** The mail builder. */
	private MailBuilder mailBuilder;

	/**
	 * Builds the mail.
	 * 
	 * @param from
	 *            the sender
	 * @param to
	 *            the recipient
	 * @param subject
	 *            the subject
	 * @param content
	 *            the content
	 * @param cc
	 *            the cc's
	 * @param attachments
	 *            the attachments
	 */
	public void buildMail(String from, String to, String subject, String content, String cc,
			String[] attachments) {
		mailBuilder.setFrom(from);
		mailBuilder.to(to).subject(subject).content(content).cc(cc).build();

	}

	/**
	 * Builds the mail.
	 * 
	 * @param from
	 *            the from
	 */
	public void buildMail(String from) {
		mailBuilder.setFrom(from);
	}

}
