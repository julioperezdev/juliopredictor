package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Delivery.DecideAuthEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.AuthenticationResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RegisterResponse;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.UserReducedResponse;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decideAuth")
@AllArgsConstructor
public class SpringDecideAuthController {

    private final DecideAuthEndPoints decideAuthEndPoints;

    @PostMapping
    public RestResponse<Object> decideAuth(@RequestBody DecideSignupLoginRequest decideSignupLoginRequest){
        Object result = decideAuthEndPoints.decideIfSignupOrLogin(decideSignupLoginRequest);
        HttpStatus httpStatus = decideHttpStatusByClass(result);
        return new RestResponse<>(httpStatus, result);
    }

    private HttpStatus decideHttpStatusByClass(Object object){
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        if(object.getClass().getSimpleName().equalsIgnoreCase(
                AuthenticationResponse.class.getSimpleName())){
            httpStatus = HttpStatus.OK;
        }
        if(object.getClass().getSimpleName().equalsIgnoreCase(
                RegisterResponse.class.getSimpleName())){
            httpStatus = HttpStatus.CREATED;
        }
        if(object.getClass().getSimpleName().equalsIgnoreCase(
                UserReducedResponse.class.getSimpleName())){
            httpStatus = HttpStatus.PARTIAL_CONTENT;
        }
        return httpStatus;
    }


}
