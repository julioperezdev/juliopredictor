package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RegisterRequest;

public interface SignupByRegisterRequest {
    Boolean signup(RegisterRequest registerRequest);
}
