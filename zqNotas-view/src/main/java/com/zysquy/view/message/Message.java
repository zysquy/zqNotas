package com.zysquy.view.message;

import com.zysquy.faulttolerance.TypeMessageSeverity;

public class Message {

	private Short errorCode;
	
	private Long trazabilityCode;
	
	private String message;
	
	private String details;
	
	private String keyMessage;
		
	private String keyDetails;
	
	private TypeMessageSeverity severity;

	public Message() {
		
	}
	
	public Message(Short errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public Message(Short errorCode, String message, String keyMessage) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.keyMessage = keyMessage;
	}



	public Short getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Short errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getKeyMessage() {
		return keyMessage;
	}

	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

	public String getKeyDetails() {
		return keyDetails;
	}

	public void setKeyDetails(String keyDetails) {
		this.keyDetails = keyDetails;
	}

	public Long getTrazabilityCode() {
		return trazabilityCode;
	}

	public void setTrazabilityCode(Long trazabilityCode) {
		this.trazabilityCode = trazabilityCode;
	}

	public TypeMessageSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(TypeMessageSeverity severity) {
		this.severity = severity;
	}
	
	
}
