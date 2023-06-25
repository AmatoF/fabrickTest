package com.fabrick.api.exception;

public enum ErrorCode {
	
	GENERIC_ERROR("000", "Generic error."),
	CLIENT_ERROR("001", "Client http error"),
    SAVE_TRANSACTION_ERROR("002", "Saving transaction to db error");

    String codError;
    String description;

    ErrorCode(String codError, String description) {
        this.codError = codError;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public String getCodError() {
        return codError;
    }


    public static ErrorCode getByCodError(String codError) {
        for (ErrorCode e : values()) {
            if (e.codError.equalsIgnoreCase(codError))
                return e;
        }
        return null;
    }

}
