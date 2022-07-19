package com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.*;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserEntity;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserRolEntity;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.VerificationTokenEntity;
import java.util.Calendar;

public class SignupModelMapper {

    public User registerRequestToUser(RegisterRequest registerRequest){
        return new User(
                registerRequest.getPassword(),
                registerRequest.getEmail(),
                Calendar.getInstance(),
                //Date.from(Instant.now()),
                Boolean.FALSE,
                registerRequest.getIdRol());
    }

    public VerificationToken userModelToVerificationToken(User recordedUser, String token){
        return new VerificationToken(
                token,
                recordedUser.getUserId());
    }

    public RegisterResponse processedSignupResponseToRegisterResponse(Boolean processedSignupResponse){
        return processedSignupResponse ?
                new RegisterResponse("generated user") :
                new RegisterResponse("failed to generate user");
    }

    public VerifyTokenResponse processedVerifyByTokenResponseToVerifyTokenResponse(User userVerified){
        UserReducedResponse userReducedResponse = new UserReducedResponse(userVerified.getEmail(), userVerified.isEnable());
        return userVerified.isEnable() ?
                new VerifyTokenResponse("user enabled", userReducedResponse) :
                new VerifyTokenResponse("failed to enable user", userReducedResponse);
    }

    public UserEntity userModelToUserEntity(User user, UserRolEntity userRolEntity){
        return new UserEntity(
                user.getEmail(),
                user.getPassword(),
                user.getCreated(),
                user.isEnable(),
                userRolEntity);
    }
    public User userEntityToUserModel(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getCreated(),
                userEntity.getEnable(),
                userEntity.getUserRol().getId());
    }

    public VerificationTokenEntity toVerificationTokenEntity(String token, UserEntity userEntity){
        return new VerificationTokenEntity(
                token,
                userEntity,
                Calendar.getInstance());
    }

    public VerificationToken toVerificationTokenModel(VerificationTokenEntity verificationTokenEntity){
        return new VerificationToken(
                verificationTokenEntity.getId(),
                verificationTokenEntity.getToken(),
                verificationTokenEntity.getUser().getId(),
                verificationTokenEntity.getExpiryDate());
    }
}
