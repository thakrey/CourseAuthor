package com.lrn.email;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * A factory for creating Message objects.
 * 
 * @author kishor.pawar
 */
public class MessageFactory {
	
	private static final Logger logger = Logger.getLogger(MessageFactory.class);
	
	/** The mail sender. */
	private JavaMailSender mailSender;
	
	/** The from. */
	private String from;
	
	/**
	 * Gets the mail sender.
	 *
	 * @return the mail sender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}



	/**
	 * Sets the mail sender.
	 *
	 * @param mailSender the new mail sender
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}



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
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}



	/**
	 * Gets the message instance.
	 *
	 * @return the message instance
	 */
	public Message getMessageInstance () {
		Message newMessage = new Message();
		newMessage.setFrom(this.from);
		newMessage.setMailSender(this.mailSender);
		
		return newMessage;
	}
}
