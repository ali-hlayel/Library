package com.member.exceptions;

public class MemberServiceException extends RuntimeException {

    public MemberServiceException(String message) {
        super(message);
    }
}
