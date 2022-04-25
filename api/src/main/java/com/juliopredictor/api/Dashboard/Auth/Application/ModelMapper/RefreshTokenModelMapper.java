package com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RefreshToken;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.RefreshTokenEntity;

public class RefreshTokenModelMapper {

    public RefreshToken toRefreshTokenModel(RefreshTokenEntity refreshTokenEntity){
        return new RefreshToken(
                refreshTokenEntity.getId(),
                refreshTokenEntity.getToken(),
                refreshTokenEntity.getCreatedDate());
    }

    public RefreshTokenEntity toRefreshEntity(RefreshToken refreshToken){
        return new RefreshTokenEntity(
                refreshToken.getToken(),
                refreshToken.getCreateDate());
    }
}
