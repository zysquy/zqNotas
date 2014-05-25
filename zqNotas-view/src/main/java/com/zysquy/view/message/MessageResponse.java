package com.zysquy.view.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageResponse implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = 7846170952489704207L;
  
  private List<Message> messages;

	public MessageResponse() {
		this.messages = new ArrayList<Message>(0);
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> errors) {
		this.messages = errors;
	}
		
	
}
