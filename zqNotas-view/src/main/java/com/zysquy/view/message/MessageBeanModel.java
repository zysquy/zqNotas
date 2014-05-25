package com.zysquy.view.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.zysquy.faulttolerance.TypeMessageSeverity;


@Component
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MessageBeanModel implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5375800258061607990L;
  
  private List<Message> messages;
  
  public MessageBeanModel() {
    messages = new ArrayList<Message>();
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
  
  public void addInfoMessage(String keyMessage) {
    Message message = new Message();
    message.setKeyMessage(keyMessage);    
    message.setSeverity(TypeMessageSeverity.INFO);
    
    this.messages.add(message);
  }
  
}
