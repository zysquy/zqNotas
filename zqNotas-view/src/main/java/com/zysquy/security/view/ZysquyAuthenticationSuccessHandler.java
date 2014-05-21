package com.zysquy.security.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class ZysquyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static String DEFAULT_TARGET_URL = "/";
	
	private String targetUrl;
	
	public ZysquyAuthenticationSuccessHandler() {
		this.targetUrl = DEFAULT_TARGET_URL;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 	throws IOException, ServletException {		
		response.setHeader("authenticated", "true");
		response.setHeader("location", request.getServletContext().getContextPath() + targetUrl);
		response.setStatus(200);
		
		//TODO:  Ver http://www.baeldung.com/spring_redirect_after_login para determinar la pagin a redirigir cuando se esta navegndo y se pierde sesion
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	

}
