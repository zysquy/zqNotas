package com.zysquy.view.message;

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
        if( messagesModel != null && messagesModel.getMessages() != null ) {
          ((ResponseREST) response).setMessages(messagesModel.getMessages() );  
        }        
      }          
      
            
      return response;
        
  }

}
