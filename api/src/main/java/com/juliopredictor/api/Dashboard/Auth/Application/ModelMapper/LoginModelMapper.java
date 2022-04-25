package com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper;

import com.juliopredictor.api.Dashboard.Auth.Application.login.Adapter.LoginAdapterSecurity;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;

import java.util.Calendar;

public class LoginModelMapper {

    private final LoginAdapterSecurity loginAdapterSecurity;

    public LoginModelMapper(LoginAdapterSecurity loginAdapterSecurity) {
        this.loginAdapterSecurity = loginAdapterSecurity;
    }

    public AuthenticationResponse toAuthenticationResponse(String token, String email, String refreshToken){
        Calendar calendarWithDateOfExpiration = this.getCalendarWithDateOfExpiration();
        return new AuthenticationResponse(
                token,
                email,
                refreshToken,
                calendarWithDateOfExpiration);
    }

    private Calendar getCalendarWithDateOfExpiration(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.sum(
                System.currentTimeMillis(),
                loginAdapterSecurity.getJwtExpirationInMillisToAuthenticationResponse()));
        return calendar;
    }

}
