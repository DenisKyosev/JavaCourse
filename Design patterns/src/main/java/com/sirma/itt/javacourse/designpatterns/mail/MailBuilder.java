package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailBuilder.
 */
public class MailBuilder extends Mail {

	/** The from. */
	private final String from;

	/** The to. */
	private String to;

	/** The subject. */
	private String subject;

	/** The content. */
	private String content;

	/** The cc. */
	private String cc;

	/** The attachments. */
	private String[] attachments;

	/**
	 * Instantiates a new mail builder.
	 * 
	 * @param from
	 *            the from
	 */
	public MailBuilder(String from) {
		this.from = from;
	}

	/**
	 * To.
	 * 
	 * @param to
	 *            the to
	 * @return the mail builder
	 */
	public MailBuilder to(String to) {
		this.to = to;
		return this;
	}

	/**
	 * Subject.
	 * 
	 * @param subject
	 *            the subject
	 * @return the mail builder
	 */
	public MailBuilder subject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Content.
	 * 
	 * @param content
	 *            the content
	 * @return the mail builder
	 */
	public MailBuilder content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Cc.
	 * 
	 * @param cc
	 *            the cc
	 * @return the mail builder
	 */
	public MailBuilder cc(String cc) {
		this.cc = cc;
		return this;
	}

	/**
	 * Attachments.
	 * 
	 * @param attachments
	 *            the attachments
	 * @return the mail builder
	 */
	public MailBuilder attachments(String[] attachments) {
		this.attachments = attachments;
		return this;
	}

	/**
	 * Builds the.
	 * 
	 * @return the mail
	 */
	public Mail build() {
		return new Mail(this);
	}
}
