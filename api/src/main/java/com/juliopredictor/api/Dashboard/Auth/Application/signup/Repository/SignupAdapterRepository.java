package com.juliopredictor.api.Dashboard.Auth.Application.signup.Repository;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.SignupModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.User;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.VerificationToken;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserRolDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserEntity;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserRolEntity;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.VerificationTokenEntity;

public class SignupAdapterRepository {

    private final UserDao userDao;
    private final VerificationTokenDao verificationTokenDao;
    private final UserRolDao userRolDao;
    private final SignupModelMapper signupModelMapper;

    public SignupAdapterRepository(UserDao userDao, VerificationTokenDao verificationTokenDao, UserRolDao userRolDao, SignupModelMapper signupModelMapper) {
        this.userDao = userDao;
        this.verificationTokenDao = verificationTokenDao;
        this.userRolDao = userRolDao;
        this.signupModelMapper = signupModelMapper;
    }



    public User createUser(User user){
        //todo: call dao to create userEntity
        UserRolEntity idRol = userRolDao.findById(user.getIdRol()).orElseThrow(() -> new RuntimeException());
        UserEntity userEntity = signupModelMapper.userModelToUserEntity(user, idRol);
        userDao.saveAndFlush(userEntity);
        //todo: check if persistence process did OK
        if(null == userEntity.getId()) throw new RuntimeException("does not saved the user in database");
        //todo: use model mapper to convert userEntity to user
        return signupModelMapper.userEntityToUserModel(userEntity);
    }

    public void createToken(String token, Long userId){
        UserEntity userEntity = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Dont exist User with this ID"));
        //todo: call dao to create tokenEntity
        VerificationTokenEntity verificationTokenEntity = signupModelMapper.toVerificationTokenEntity(token, userEntity);
        verificationTokenDao.saveAndFlush(verificationTokenEntity);
        //todo: check if persistence process did OK
        if(null == verificationTokenEntity.getId()) throw new RuntimeException("does not saved the token");
    }

    public VerificationToken getVerificationTokenByToken(String token){
        //todo: use model mapper to convert verificationTokenEntity to verificationToken
        VerificationTokenEntity verificationTokenFound = verificationTokenDao.findFirstByToken(token).orElseThrow(() -> new RuntimeException("this token does not exist"));
        return signupModelMapper.toVerificationTokenModel(verificationTokenFound);
    }

    public User getUserById(Long userId){
        //todo: call dao to get userEntity
        //todo: check if userEntity exist
        UserEntity userEntityFound = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User does not exist"));
        //todo: use model mapper to convert userEntity to user
        return signupModelMapper.userEntityToUserModel(userEntityFound);
    }

    public User updateStatusToEnableAUser(Long userId){
        //todo: call dao to update userEntity to enable in the security system
        UserEntity userEntityFound = userDao.findById(userId).orElseThrow(() -> new RuntimeException("does not exist user"));
        userEntityFound.setEnable(Boolean.TRUE);
        userDao.saveAndFlush(userEntityFound);
        return signupModelMapper.userEntityToUserModel(userEntityFound);
    }
}
