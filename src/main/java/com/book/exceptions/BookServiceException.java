package com.book.exceptions;

public class BookServiceException extends RuntimeException {

    public BookServiceException(String message) {
        super(message);
    }
}
