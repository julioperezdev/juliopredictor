package com.juliopredictor.api.Dashboard.Auth.Application.signup.Service;

import com.juliopredictor.api.Dashboard.Auth.Domain.Port.SignupByRegisterRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Port.VerifyAccountByToken;

public interface SignupService extends VerifyAccountByToken, SignupByRegisterRequest {
}
