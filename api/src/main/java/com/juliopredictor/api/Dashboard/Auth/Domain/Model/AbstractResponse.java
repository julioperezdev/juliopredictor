package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class AbstractResponse {

    private String message;

    public AbstractResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
