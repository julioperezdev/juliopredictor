package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.LoginRequest;

public interface LoginByLoginRequest {
    AuthenticationResponse login(LoginRequest loginRequest);
}
