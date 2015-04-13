package com.lrn.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * The Class Sender Will be defined as a non singleton class and should be instantiated each time.
 * This class has setters for each part of the email to send (to, from, cc, bcc, title, body) and
 * allows the user to send out the email.
 * 
 * @author kishor.pawar
 */
public class Message {
	
	private static final Logger logger = Logger.getLogger(Message.class);
	
	/** The mail sender. */
	private JavaMailSender mailSender;
    
    /** The recepients. */
    private List<String> recepients = new ArrayList<String>();
    
    /** The cc. */
    private List<String> cc = new ArrayList<String>();
    
    /** The bcc. */
    private List<String> bcc = new ArrayList<String>();
    
    /** The from. */
    private String from;
    
    /** The body. */
    private String body;
    
    /** The title. */
    private String title;
    
    /** The message. */
    private SimpleMailMessage message;
	
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
	 * Gets the recepients.
	 *
	 * @return the recepients
	 */
	public List<String> getRecepients() {
		return recepients;
	}
	
	/**
	 * Sets the recepients.
	 *
	 * @param recepients the new recepients
	 */
	public void setRecepients(List<String> recepients) {
		this.recepients = recepients;
	}
	
	/**
	 * Gets the cc.
	 *
	 * @return the cc
	 */
	public List<String> getCc() {
		return cc;
	}
	
	/**
	 * Sets the cc.
	 *
	 * @param cc the new cc
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	
	/**
	 * Gets the bcc.
	 *
	 * @return the bcc
	 */
	public List<String> getBcc() {
		return bcc;
	}
	
	/**
	 * Sets the bcc.
	 *
	 * @param bcc the new bcc
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
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
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Adds recepient.
	 *
	 * @param to the to
	 */
	public void addRecepient(String to) {
		this.recepients.add(to);
	}
	
	/**
	 * Adds cc.
	 *
	 * @param cc the cc
	 */
	public void addCC(String cc) {
		this.cc.add(cc);
	}
	
	/**
	 * Adds bcc.
	 *
	 * @param bcc the bcc
	 */
	public void addBCC(String bcc) {
		this.bcc.add(bcc);
	}
    
    /**
     * Send email.
     */
    public void sendEmail() {
        this.message = new SimpleMailMessage();
        this.message.setBcc(this.bcc.toArray(new String[0]));
        this.message.setCc(this.cc.toArray(new String[0]));
        this.message.setFrom(this.from);
        this.message.setSentDate(new Date());
        this.message.setSubject(this.title);
        this.message.setText(this.body);
        this.message.setTo(this.recepients.toArray(new String[0]));
        logger.debug("sending email to "+ this.getRecepients().get(0));
        
        this.mailSender.send(this.message);
    }
}
