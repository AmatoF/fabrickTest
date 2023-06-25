package com.fabrick.api.exception;

public class DaoException extends Exception {

    private final String message;

    public DaoException(String message) {
        super();
        this.message=message;
    }

    public DaoException(Exception e, String message) {
        super(e);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
