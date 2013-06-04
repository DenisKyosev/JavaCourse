package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class Mail.
 */
public class Mail {

	/**
	 * Instantiates a new mail.
	 */
	public Mail() {

	}

	/**
	 * Instantiates a new mail.
	 * 
	 * @param builder
	 *            the builder
	 */
	public Mail(MailBuilder builder) {
		from = builder.getFrom();
		to = builder.getTo();
		subject = builder.getSubject();
		content = builder.getContent();
		cc = builder.getCc();
		attachments = builder.getAttachments();
	}

	/** Sender. */
	private String from;

	/** The recipient. */
	private String to;

	/** The subject. */
	private String subject;

	/** The content. */
	private String content;

	/** The cc's. */
	private String cc;

	/** The attachments. */
	private String[] attachments;

	/**
	 * Gets sender.
	 * 
	 * @return the sender
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the sender.
	 * 
	 * @param from
	 *            the new sender
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets to.
	 * 
	 * @return to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets to.
	 * 
	 * @param to
	 *            to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject
	 *            the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 * 
	 * @param content
	 *            the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the cc.
	 * 
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * Sets the cc.
	 * 
	 * @param cc
	 *            the new cc
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * Gets the attachments.
	 * 
	 * @return the attachments
	 */
	public String[] getAttachments() {
		return attachments;
	}

	/**
	 * Sets the attachments.
	 * 
	 * @param attachments
	 *            the new attachments
	 */
	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

}
