package com.fabrick.api.exception;

public class BankTransferException extends GenericException {

    public BankTransferException(String message) {
        super(message);
    }

    public BankTransferException(Exception e, String message) {
        super(e, message);
    }

    public BankTransferException(String message, Throwable t) {
        super(message, t);
    }

    public BankTransferException(Exception e, String message, ErrorCode errorCode) {
        super(e, message, errorCode);
    }

    public BankTransferException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
