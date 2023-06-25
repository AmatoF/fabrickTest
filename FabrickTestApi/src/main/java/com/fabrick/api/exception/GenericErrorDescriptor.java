package com.fabrick.api.exception;

public class GenericErrorDescriptor {

	private String errorMessage;
	private String exceptionErrorMessage;
	private String errorURI;
	private String errorCode;
	private Class<? extends Exception> exceptionThrown;
	private ValidationError validationError;
	
	public GenericErrorDescriptor() {	}
	
	public GenericErrorDescriptor(String errorMessage, String exceptionErrorMessage, String errorURI, String errorCode,
                                  Class<? extends Exception> exceptionThrown, ValidationError validationError) {
		super();
		this.errorMessage = errorMessage;
		this.exceptionErrorMessage = exceptionErrorMessage;
		this.errorURI = errorURI;
		this.errorCode = errorCode;
		this.exceptionThrown = exceptionThrown;
		this.validationError = validationError;
	}
	
	public GenericErrorDescriptor(String errorMessage, String exceptionErrorMessage, String errorURI, String errorCode,
                                  Class<? extends Exception> exceptionThrown) {
		super();
		this.errorMessage = errorMessage;
		this.exceptionErrorMessage = exceptionErrorMessage;
		this.errorURI = errorURI;
		this.errorCode = errorCode;
		this.exceptionThrown = exceptionThrown;
	}

	
	
	public GenericErrorDescriptor(String errorMessage, String errorURI, Class<? extends Exception> class1) {
		super();
		this.errorMessage = errorMessage;
		this.errorURI = errorURI;
		this.exceptionThrown = class1;
	}
	
	
	public GenericErrorDescriptor(String errorUri, Class<? extends Exception> exception) {
		super();
		this.errorURI=errorUri;
		this.exceptionThrown = exception;
	}
	
	

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getExceptionErrorMessage() {
		return exceptionErrorMessage;
	}

	public String getErrorURI() {
		return errorURI;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Class<? extends Exception> getExceptionThrown() {
		return exceptionThrown;
	}

	public ValidationError getValidationError() {
		return validationError;
	}
	
	@Override
	public String toString(){
		return this.errorURI + " threw an exception with message " + this.errorMessage + ". Inner error message: [" + this.exceptionErrorMessage + "] with errorCode: "+this.errorCode;
	}
	
}