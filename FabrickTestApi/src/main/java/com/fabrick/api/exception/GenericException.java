package com.fabrick.api.exception;

public abstract class GenericException extends Exception {


	private static final long serialVersionUID = -1756770348590809869L;
	
	String message;
	ErrorCode errorCode;
	
	public GenericException(String message){
		super(message);
		this.message=message;
	}
	
	public GenericException(Exception e, String message){
		super(e);
		this.message=message;
	}
	
	public GenericException(String message, Throwable t){
		super(message,t);
	}
	
	public GenericException(Exception e, String message, ErrorCode errorCode){
		super(e);
		this.message=message;
		this.errorCode=errorCode;
	}
	
	public GenericException(String message, ErrorCode errorCode){
		this.message=message;
		this.errorCode=errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
