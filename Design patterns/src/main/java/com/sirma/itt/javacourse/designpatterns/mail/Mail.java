package com.sirma.itt.javacourse.designpatterns.mail;

// TODO: Auto-generated Javadoc
/**
 * The Class Mail.
 */
public class Mail {

	/** The from. */
	private String from;

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
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 * 
	 * @param from
	 *            the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 * 
	 * @param to
	 *            the new to
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
