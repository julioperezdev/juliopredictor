package com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.*;

public class DecideAuthModelMapper {

    public LoginRequest emailToLoginRequest(DecideSignupLoginRequest decideSignupLoginRequest){
        return new LoginRequest(
                decideSignupLoginRequest.getEmail());
    }

    public RegisterRequest emailToRegisterRequest(DecideSignupLoginRequest decideSignupLoginRequest){
        return new RegisterRequest(
                decideSignupLoginRequest.getEmail(),
                1L);
    }

    public UserReducedResponse userToUserReducedResponse(User user){
        return new UserReducedResponse(
                user.getEmail(),
                user.isEnable());
    }
}
