package com.zysquy.faulttolerance;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zysquy.view.message.Message;
import com.zysquy.view.message.MessageResponse;


@ControllerAdvice
public class ZysquyExceptionHandler {
	/*
	 * View: http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
	 */
	
	@ExceptionHandler(value=RuntimeException.class)	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
    public MessageResponse defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		MessageResponse response = new MessageResponse();
			
		Message messageError = new Message((short)1, "Error fatal", e.getMessage());
		messageError.setSeverity(TypeMessageSeverity.FATAL);
		response.getMessages().add(messageError);
				
		return response;
	}
		
}
