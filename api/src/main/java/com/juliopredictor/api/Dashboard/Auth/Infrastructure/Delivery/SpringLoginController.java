package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.login.Delivery.LoginEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.LoginRequest;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class SpringLoginController {

    private final LoginEndPoints loginEndPoints;

    @PostMapping
    public RestResponse<AuthenticationResponse> loginUser(@RequestBody LoginRequest loginRequest){
        AuthenticationResponse authenticationResponse = loginEndPoints.loginUser(loginRequest);
        return new RestResponse<>(HttpStatus.ACCEPTED, authenticationResponse);
    }
}
