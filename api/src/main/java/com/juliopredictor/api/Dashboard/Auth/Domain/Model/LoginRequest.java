package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class LoginRequest {
    private String email;
    private String password;
    private final String CONSTANT_PASSWORD = "authorize_with_only_email";

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = CONSTANT_PASSWORD;
    }
    public LoginRequest(String email) {
        this.email = email;
        this.password = CONSTANT_PASSWORD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
