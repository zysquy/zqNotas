package com.zysquy.failuretolerance;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ZysquyExceptionHandler {
	/*
	 * View: http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
	 */
	
	@ExceptionHandler(value=RuntimeException.class)	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
    public MessageErrorResponse defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		MessageErrorResponse response = new MessageErrorResponse();
			
		MessageError messageError = new MessageError((short)1, "Error fatal", e.getMessage());
		response.getErrors().add(messageError);
				
		return response;
	}
		
}
