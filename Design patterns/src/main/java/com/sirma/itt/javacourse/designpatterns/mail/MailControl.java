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
	 *            the from
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param content
	 *            the content
	 * @param cc
	 *            the cc
	 * @param attachments
	 *            the attachments
	 * @return the mail
	 */
	public Mail buildMail(String from, String to, String subject, String content, String cc,
			String[] attachments) {
		if (!from.isEmpty()) {
			return mailBuilder.from(from).to(to).subject(subject).content(content).cc(cc).build();
		} else {
			return null;
		}
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
