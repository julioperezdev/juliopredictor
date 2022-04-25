package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

import java.util.Calendar;
import java.util.Date;

public class RefreshToken {
    private Long id;
    private String token;
    private Calendar createDate;

    public RefreshToken(Long id, String token, Calendar createDate) {
        this.id = id;
        this.token = token;
        this.createDate = createDate;
    }

    public RefreshToken(String token, Calendar createDate) {
        this.token = token;
        this.createDate = createDate;
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

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }
}
