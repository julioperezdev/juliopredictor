package com.juliopredictor.api.Dashboard.Auth.Application.login.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.login.Service.LoginService;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.LoginRequest;

public class LoginEndPoints {

    private final LoginService loginService;

    public LoginEndPoints(LoginService loginService) {
        this.loginService = loginService;
    }

    public AuthenticationResponse loginUser(LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }


}
