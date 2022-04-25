package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

public interface FetchUserAndEnableByVerificationToken {
    void fetchUserAndEnable(VerificationToken verificationToken);
}
