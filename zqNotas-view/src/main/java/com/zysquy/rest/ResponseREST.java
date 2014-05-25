package com.zysquy.rest;

import com.zysquy.view.message.MessageResponse;

public class ResponseREST {
  
  private MessageResponse messages;
  
  private Object data;

  public ResponseREST() {   
  }
     
  public ResponseREST(Object data) {
    super();
    this.data = data;
  }



  public MessageResponse getMessages() {
    return messages;
  }

  public void setMessages(MessageResponse messages) {
    this.messages = messages;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
  
  
}
