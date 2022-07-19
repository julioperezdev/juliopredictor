package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class VerifyTokenResponse extends AbstractResponse{

    private UserReducedResponse userVerified;

    public VerifyTokenResponse(String message, UserReducedResponse userVerified) {
        super(message);
        this.userVerified = userVerified;
    }

    public VerifyTokenResponse(String message) {
        super(message);
    }

    public UserReducedResponse getUserVerified() {
        return userVerified;
    }

    public void setUserVerified(UserReducedResponse userVerified) {
        this.userVerified = userVerified;
    }
}
