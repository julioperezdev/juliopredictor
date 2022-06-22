package com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.DecideAuthModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Service.DecideAuthService;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Delivery.LoginEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.signup.Delivery.SignupEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.*;
import org.springframework.util.ObjectUtils;

import java.util.Map;

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
        Map<Boolean, User> validationData = decideAuthService.validateIfUserExistToSignupOrLogin(decideSignupLoginRequest);
        boolean decision = validationData.containsKey(Boolean.TRUE);
        Object result = decision
                ? returnUserThatNotIsVerified(validationData.get(Boolean.TRUE))
                : logicToSignupOrLogin(validationData.get(Boolean.FALSE), decideSignupLoginRequest);
        System.out.println(result.toString());
        return result;
    }

    private UserReducedResponse returnUserThatNotIsVerified(User user){
        return decideAuthModelMapper.userToUserReducedResponse(user);
    }
    private Object logicToSignupOrLogin(User user, DecideSignupLoginRequest decideSignupLoginRequest){
        return ObjectUtils.isEmpty(user)
                ? executeSignupEndPoint(decideSignupLoginRequest)
                :executeLoginEndPoint(decideSignupLoginRequest);
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
