package com.juliopredictor.api.Dashboard.Auth.Application.login.Service;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.LoginModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Adapter.LoginAdapterSecurity;
import com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Service.RefreshTokenService;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.LoginRequest;

public class LoginServiceImplementation implements LoginService{

    private final LoginAdapterSecurity loginAdapterSecurity;
    private final LoginModelMapper loginModelMapper;
    private final RefreshTokenService refreshTokenService;

    public LoginServiceImplementation(LoginAdapterSecurity loginAdapterSecurity, LoginModelMapper loginModelMapper, RefreshTokenService refreshTokenService) {
        this.loginAdapterSecurity = loginAdapterSecurity;
        this.loginModelMapper = loginModelMapper;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        String tokenGenerated = loginAdapterSecurity.generateTokenByLoginRequest(loginRequest);
        String refreshTokenGenerated = refreshTokenService.generateRefreshToken().getToken();
        return loginModelMapper.toAuthenticationResponse(
                tokenGenerated,
                loginRequest.getEmail(),
                refreshTokenGenerated);
    }
}
