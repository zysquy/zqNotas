package com.zysquy.rest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.zysquy.failuretolerance.MessageError;


@Aspect
public class HandlerExceptionsInRESTAspect {
	
	
	//	@Around("this(com.zysquy.rest.ZysquyRESTSrv)")
	//@Around("within(com.zysquy.zqnotas.rest.services..*)")	
	//@Around("execution(* com.zysquy.zqnotas.rest.services.EstablecimientosEducRESTSrv.list(..))")
	//@Around("@within(org.springframework.stereotype.Controller)")
	//@Around("this(com.zysquy.rest.ZysquyRESTSrv)")
	private Object around(ProceedingJoinPoint pjp) {		
		try {
			System.out.println(".....................................Paso por el Aspecto..................................................");
			return pjp.proceed();
		} catch(Throwable ex) {
			MessageErrorRESTResponse response = new MessageErrorRESTResponse();
			if( ex instanceof RuntimeException ) {				
				MessageError messageError = new MessageError((short)1, "Error fatal", ex.getMessage());
				response.getErrors().add(messageError);
			}
			return response.getErrors();
		}
	}	
	
	
}
