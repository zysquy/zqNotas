package com.zysquy.failuretolerance;

import java.util.ArrayList;
import java.util.List;

public class MessageErrorResponse {

	private List<MessageError> errors;

	public MessageErrorResponse() {
		this.errors = new ArrayList<MessageError>(0);
	}
	
	public List<MessageError> getErrors() {
		return errors;
	}

	public void setErrors(List<MessageError> errors) {
		this.errors = errors;
	}
		
	
}
