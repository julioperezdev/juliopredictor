package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

public interface ValidateRefreshTokenByToken {
    void validateRefreshToken(String token);
}
