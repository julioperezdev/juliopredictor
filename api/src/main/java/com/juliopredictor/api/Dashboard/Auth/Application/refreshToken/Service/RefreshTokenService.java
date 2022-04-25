package com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Service;

import com.juliopredictor.api.Dashboard.Auth.Domain.Port.DeleteRefreshTokenByToken;
import com.juliopredictor.api.Dashboard.Auth.Domain.Port.GenerateRefreshToken;
import com.juliopredictor.api.Dashboard.Auth.Domain.Port.ValidateRefreshTokenByToken;

public interface RefreshTokenService extends
        GenerateRefreshToken,
        ValidateRefreshTokenByToken,
        DeleteRefreshTokenByToken {
}
