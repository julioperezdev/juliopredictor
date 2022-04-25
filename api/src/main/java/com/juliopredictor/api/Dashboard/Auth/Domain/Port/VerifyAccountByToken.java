package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.VerifyTokenResponse;

public interface VerifyAccountByToken {
    VerifyTokenResponse verifyAccount(String token);
}
