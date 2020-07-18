package com.book.exceptions;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXIST("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    BOOK_IS_NOT_FOUND("Book is not found in the database");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
