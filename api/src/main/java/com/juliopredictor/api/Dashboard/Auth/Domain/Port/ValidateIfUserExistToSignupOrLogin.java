package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.User;

import java.util.Map;

public interface ValidateIfUserExistToSignupOrLogin {
    Map<Boolean, User> validateIfUserExistToSignupOrLogin(DecideSignupLoginRequest decideSignupLoginRequest);
}
