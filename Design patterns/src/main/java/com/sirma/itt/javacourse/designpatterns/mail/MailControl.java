package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailControl.
 */
public class MailControl {

	/** The mail builder. */
	private EmailBuilder mailBuilder;

	/**
	 * Gets the mail builder.
	 * 
	 * @return the mail builder
	 */
	public EmailBuilder getMailBuilder() {
		return mailBuilder;
	}

	/**
	 * Sets the mail builder.
	 * 
	 * @param mailBuilder
	 *            the new mail builder
	 */
	public void setMailBuilder(EmailBuilder mailBuilder) {
		this.mailBuilder = mailBuilder;
	}

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
		mailBuilder.from(from).to(to).subject(subject).content(content).cc(cc)
				.attachments(attachments);
	}

}
