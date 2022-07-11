package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class VerifyTokenResponse extends AbstractResponse{

    private User userVerified;

    public VerifyTokenResponse(String message, User userVerified) {
        super(message);
        this.userVerified = userVerified;
    }

    public VerifyTokenResponse(String message) {
        super(message);
    }

    public User getUserVerified() {
        return userVerified;
    }

    public void setUserVerified(User userVerified) {
        this.userVerified = userVerified;
    }
}
