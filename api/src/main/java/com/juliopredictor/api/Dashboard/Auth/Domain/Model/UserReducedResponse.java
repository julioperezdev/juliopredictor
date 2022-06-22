package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

public class UserReducedResponse {
    private String email;
    private Boolean enable;

    public UserReducedResponse(String email, Boolean enable) {
        this.email = email;
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
