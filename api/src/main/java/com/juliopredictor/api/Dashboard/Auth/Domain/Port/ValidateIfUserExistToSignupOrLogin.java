package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;

public interface ValidateIfUserExistToSignupOrLogin {
    Boolean validateIfUserExistToSignupOrLogin(DecideSignupLoginRequest decideSignupLoginRequest);
}
