package com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Service;

import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Adapter.DecideAuthAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.User;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DecideAuthServiceImplementation implements DecideAuthService{

    private final DecideAuthAdapterRepository decideAuthAdapterRepository;

    public DecideAuthServiceImplementation(DecideAuthAdapterRepository decideAuthAdapterRepository) {
        this.decideAuthAdapterRepository = decideAuthAdapterRepository;
    }

    @Override
    public Map<Boolean, User> validateIfUserExistToSignupOrLogin(DecideSignupLoginRequest decideSignupLoginRequest) {
        User userByEmail = null;
        Map<Boolean, User> userThatNeedBeSignupIt = new HashMap<>();
        userThatNeedBeSignupIt.put(Boolean.FALSE, null);
        try{
            userByEmail = decideAuthAdapterRepository.getUserByEmail(decideSignupLoginRequest.getEmail());
            if(ObjectUtils.isEmpty(userByEmail)){
                return userThatNeedBeSignupIt;
            }
            if(userByEmail.isEnable()){
                return Map.of(Boolean.FALSE, userByEmail);
            }

        }catch (Exception error){
            return userThatNeedBeSignupIt;
        }
        return Map.of(Boolean.TRUE, userByEmail);
    }


}
