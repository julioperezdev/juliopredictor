package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class DecideSignupLoginRequest {

    private String email;

    public DecideSignupLoginRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
