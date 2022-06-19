package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Delivery.DecideAuthEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decideAuth")
@AllArgsConstructor
public class SpringDecideAuthController {

    private final DecideAuthEndPoints decideAuthEndPoints;

    @PostMapping
    public RestResponse<Object> decideAuth(DecideSignupLoginRequest decideSignupLoginRequest){
        Object result = decideAuthEndPoints.decideIfSignupOrLogin(decideSignupLoginRequest);
        return new RestResponse<>(HttpStatus.ACCEPTED, result);
    }


}
