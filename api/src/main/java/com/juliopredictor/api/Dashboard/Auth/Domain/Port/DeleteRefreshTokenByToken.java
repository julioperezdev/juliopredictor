package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

public interface DeleteRefreshTokenByToken {
    void deleteRefreshToken(String token);
}
