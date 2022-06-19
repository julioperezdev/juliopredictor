package com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.DecideAuthModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Service.DecideAuthService;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Delivery.LoginEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.signup.Delivery.SignupEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.*;

public class DecideAuthEndPoints {

    private final LoginEndPoints loginEndPoints;
    private final SignupEndPoints signupEndPoints;
    private final DecideAuthService decideAuthService;
    private final DecideAuthModelMapper decideAuthModelMapper;

    public DecideAuthEndPoints(LoginEndPoints loginEndPoints, SignupEndPoints signupEndPoints, DecideAuthService decideAuthService, DecideAuthModelMapper decideAuthModelMapper) {
        this.loginEndPoints = loginEndPoints;
        this.signupEndPoints = signupEndPoints;
        this.decideAuthService = decideAuthService;
        this.decideAuthModelMapper = decideAuthModelMapper;
    }

    public Object decideIfSignupOrLogin(DecideSignupLoginRequest decideSignupLoginRequest){
        Object result = decideAuthService.validateIfUserExistToSignupOrLogin(decideSignupLoginRequest)
                ? executeLoginEndPoint(decideSignupLoginRequest)
                : executeSignupEndPoint(decideSignupLoginRequest);
        System.out.println(result.toString());
        return result;
    }

    private AuthenticationResponse executeLoginEndPoint(DecideSignupLoginRequest decideSignupLoginRequest){
        LoginRequest loginRequest = decideAuthModelMapper.emailToLoginRequest(decideSignupLoginRequest);
        return loginEndPoints.loginUser(loginRequest);
    }
    private RegisterResponse executeSignupEndPoint(DecideSignupLoginRequest decideSignupLoginRequest){
        RegisterRequest registerRequest = decideAuthModelMapper.emailToRegisterRequest(decideSignupLoginRequest);
        return signupEndPoints.signupUser(registerRequest);
    }



}
