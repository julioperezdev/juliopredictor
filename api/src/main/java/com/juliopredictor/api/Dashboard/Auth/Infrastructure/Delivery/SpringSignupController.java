package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.signup.Delivery.SignupEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RegisterRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RegisterResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.VerifyTokenResponse;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
@AllArgsConstructor
public class SpringSignupController {

    private final SignupEndPoints signupEndPoints;

    @PostMapping("/user")
    public RestResponse<RegisterResponse> signupUser(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = signupEndPoints.signupUser(registerRequest);
        return new RestResponse<>(HttpStatus.CREATED, registerResponse);
    }

    @GetMapping("/token/{token}")
    public RestResponse<VerifyTokenResponse> verificationToken(@PathVariable String token){
        VerifyTokenResponse verifyTokenResponse = signupEndPoints.verifyAccountByToken(token);
        return new RestResponse<>(HttpStatus.ACCEPTED, verifyTokenResponse);
    }
}
