package com.juliopredictor.api.Dashboard.Auth.Domain.Model;

import java.util.Calendar;
import java.util.Date;

public class User {

    private Long id;
    private String password;
    private String email;
    private Calendar created;
    private Boolean enable;
    private Long idRol;

    public User(Long id, String password, String email, Calendar created, Boolean enable, Long idRol) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }

    public User( String password, String email, Calendar created, Boolean enable, Long idRol) {
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
