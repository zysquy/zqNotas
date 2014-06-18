package com.zysquy.rest;

import java.util.List;

import com.zysquy.view.message.Message;

public class ResponseREST {
  
  private List<Message> messages;
  
  private Object data;

  public ResponseREST() {   
  }
     
  public ResponseREST(Object data) {
    super();
    this.data = data;
  }



  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
  
  
}
