package com.juliopredictor.api.Shared.Domain;

public class ExceptionResponse {
    private String status;
    private int status_code;
    private String exception;

    public ExceptionResponse(String status, int status_code, String exception) {
        this.status = status;
        this.status_code = status_code;
        this.exception = exception;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}