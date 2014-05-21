package com.zysquy.security.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class ZysquyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 	HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		response.setHeader("authenticated", "false");
		response.setHeader("message-error-auth", exception.getMessage());
		response.setStatus(200);
		//super.onAuthenticationFailure(request, response, exception);
	}

	
	
}
