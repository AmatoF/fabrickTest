package com.fabrick.api.exception;

public class SaveTransactionException extends GenericException {

    public SaveTransactionException(String message) {
        super(message);
    }

    public SaveTransactionException(Exception e, String message) {
        super(e, message);
    }

    public SaveTransactionException(String message, Throwable t) {
        super(message, t);
    }

    public SaveTransactionException(Exception e, String message, ErrorCode errorCode) {
        super(e, message, errorCode);
    }

    public SaveTransactionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
