package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

public interface AuthService extends SignupByRegisterRequest, VerifyAccountByToken, FetchUserAndEnableByVerificationToken, LoginByLoginRequest{
}
