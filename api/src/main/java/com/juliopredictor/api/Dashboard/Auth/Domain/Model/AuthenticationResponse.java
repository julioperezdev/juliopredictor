package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
    private String refreshToken;
    private Calendar expireAt;

    public AuthenticationResponse(String authenticationToken, String username, String refreshToken, Calendar expireAt) {
        this.authenticationToken = authenticationToken;
        this.username = username;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Calendar getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Calendar expireAt) {
        this.expireAt = expireAt;
    }
}
