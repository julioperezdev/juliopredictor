package com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Service;

import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Adapter.DecideAuthAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.DecideSignupLoginRequest;
import com.juliopredictor.api.Dashboard.Auth.Domain.Model.User;
import org.springframework.util.ObjectUtils;

public class DecideAuthServiceImplementation implements DecideAuthService{

    private final DecideAuthAdapterRepository decideAuthAdapterRepository;

    public DecideAuthServiceImplementation(DecideAuthAdapterRepository decideAuthAdapterRepository) {
        this.decideAuthAdapterRepository = decideAuthAdapterRepository;
    }

    @Override
    public Boolean validateIfUserExistToSignupOrLogin(DecideSignupLoginRequest decideSignupLoginRequest) {
        try{
            User userByEmail = decideAuthAdapterRepository.getUserByEmail(decideSignupLoginRequest.getEmail());
            if(ObjectUtils.isEmpty(userByEmail)){
                return Boolean.FALSE;
            }
        }catch (Exception error){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}
