package com.book.exceptions;

import java.util.Date;

public class ApiError {

    private int status;

    private String developerMessage;

    private Date timeStamp;

    private String message;

    public ApiError(final int status, final String message, final String developerMessage) {
        super();
        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public ApiError(Date timeStamp, String message) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
