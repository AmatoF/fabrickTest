package com.fabrick.api.exception;

public class GetBalanceException extends GenericException {

    public GetBalanceException(String message) {
        super(message);
    }

    public GetBalanceException(Exception e, String message) {
        super(e, message);
    }

    public GetBalanceException(String message, Throwable t) {
        super(message, t);
    }

    public GetBalanceException(Exception e, String message, ErrorCode errorCode) {
        super(e, message, errorCode);
    }

    public GetBalanceException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
