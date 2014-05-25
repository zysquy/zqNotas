package com.zysquy.view.message;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.zysquy.rest.ResponseREST;

@Aspect
public class AddMessagesResponseRESTInterceptor {
  
  @Autowired
  private MessageBeanModel messagesModel;

 @Around("@annotation(com.zysquy.view.message.annotations.MessageRESTInterceptor)")
  private Object around(ProceedingJoinPoint pjp) throws Throwable {
         
      Object response = pjp.proceed();
      
      if( response instanceof ResponseREST ) {
        MessageResponse messageResponse = new MessageResponse();             
        
        if( messagesModel != null && messagesModel.getMessages() != null ) {
          if(messageResponse.getMessages() == null) {
            messageResponse.setMessages(new ArrayList<Message>( messagesModel.getMessages() ));
          } else {
            messageResponse.getMessages().addAll(messagesModel.getMessages());
          }
        }
        ((ResponseREST) response).setMessages(messageResponse);
      }          
      
            
      return response;
        
  }

}
