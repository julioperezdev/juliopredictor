package com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Adapter;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.RefreshTokenModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RefreshToken;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.RefreshTokenEntity;

public class RefreshTokenAdapterRepository {

    private final RefreshTokenDao refreshTokenDao;
    private final RefreshTokenModelMapper refreshTokenModelMapper;

    public RefreshTokenAdapterRepository(RefreshTokenDao refreshTokenDao, RefreshTokenModelMapper refreshTokenModelMapper) {
        this.refreshTokenDao = refreshTokenDao;
        this.refreshTokenModelMapper = refreshTokenModelMapper;
    }

    public RefreshToken createRefreshToken(RefreshToken refreshToken){
        RefreshTokenEntity refreshTokenEntity = refreshTokenModelMapper.toRefreshEntity(refreshToken);
        refreshTokenDao.saveAndFlush(refreshTokenEntity);
        if(null == refreshTokenEntity.getId()) throw new RuntimeException("Does not create refresh token");
        return refreshTokenModelMapper.toRefreshTokenModel(refreshTokenEntity);
    }

    public void validateRefreshToken(String token){
        refreshTokenDao.findFirstByToken(token).orElseThrow(() -> new RuntimeException("Does not exist the refresh token"));
    }

    public void deleteRefreshToken(String token){
        refreshTokenDao.deleteByToken(token);
    }
}
