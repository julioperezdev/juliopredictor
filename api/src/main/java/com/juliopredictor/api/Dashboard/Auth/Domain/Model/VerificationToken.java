package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

import java.time.Instant;
import java.util.Calendar;

public class VerificationToken {

    private Long id;
    private String token;
    private Long userId;
    private Calendar expiryDate;

    public VerificationToken(Long id, String token, Long userId, Calendar expiryDate) {
        this.id = id;
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }

    public VerificationToken(String token, Long userId, Calendar expiryDate) {
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }

    public VerificationToken(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }
}
