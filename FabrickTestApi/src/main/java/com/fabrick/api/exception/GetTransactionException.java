package com.fabrick.api.exception;

public class GetTransactionException extends GenericException {

    public GetTransactionException(String message) {
        super(message);
    }

    public GetTransactionException(Exception e, String message) {
        super(e, message);
    }

    public GetTransactionException(String message, Throwable t) {
        super(message, t);
    }

    public GetTransactionException(Exception e, String message, ErrorCode errorCode) {
        super(e, message, errorCode);
    }

    public GetTransactionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
