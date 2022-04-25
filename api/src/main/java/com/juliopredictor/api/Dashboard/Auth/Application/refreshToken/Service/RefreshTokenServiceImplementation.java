package com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Service;

import com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Adapter.RefreshTokenAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RefreshToken;
import java.util.Calendar;
import java.util.UUID;

public class RefreshTokenServiceImplementation implements RefreshTokenService{

    private final RefreshTokenAdapterRepository refreshTokenAdapterRepository;

    public RefreshTokenServiceImplementation(RefreshTokenAdapterRepository refreshTokenAdapterRepository) {
        this.refreshTokenAdapterRepository = refreshTokenAdapterRepository;
    }

    @Override
    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken(
                UUID.randomUUID().toString(),
                Calendar.getInstance());
        return refreshTokenAdapterRepository.createRefreshToken(refreshToken);
    }

    @Override
    public void validateRefreshToken(String token) {

    }

    @Override
    public void deleteRefreshToken(String token) {

    }
}
