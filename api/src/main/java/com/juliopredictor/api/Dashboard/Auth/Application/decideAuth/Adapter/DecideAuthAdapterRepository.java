package com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Adapter;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.SignupModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.User;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserEntity;

public class DecideAuthAdapterRepository {

    private final UserDao userDao;
    private final SignupModelMapper signupModelMapper;

    public DecideAuthAdapterRepository(UserDao userDao, SignupModelMapper signupModelMapper) {
        this.userDao = userDao;
        this.signupModelMapper = signupModelMapper;
    }

    public User getUserByEmail(String email){
        //todo: call dao to get userEntity
        //todo: check if userEntity exist
        UserEntity userEntityFound = userDao.findFirstByEmail(email).orElseThrow(() -> new RuntimeException("User does not exist"));
        //todo: use model mapper to convert userEntity to user
        return signupModelMapper.userEntityToUserModel(userEntityFound);
    }
}
