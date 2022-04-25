package com.juliopredictor.api.Dashboard.Auth.Application.login.Adapter;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.LoginRequest;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security.JwtProvider;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security.ManagerAuthenticator;
import org.springframework.security.core.Authentication;

public class LoginAdapterSecurity {

    private final ManagerAuthenticator managerAuthenticator;
    //private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public LoginAdapterSecurity(ManagerAuthenticator managerAuthenticator, JwtProvider jwtProvider) {
        this.managerAuthenticator = managerAuthenticator;
        //this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public String generateTokenByLoginRequest(LoginRequest loginRequest){
        Authentication authentication = this.authenticateWithManager(loginRequest);
        return jwtProvider.generateToken(authentication);
    }

    private Authentication authenticateWithManager(LoginRequest loginRequest){
        Authentication authentication = managerAuthenticator.authenticateByEmailAndPassword(loginRequest);
        //Authentication authentication = this.authenticateByEmailAndPassword(loginRequest);
        managerAuthenticator.setAuthenticationToSecurityContext(authentication);
        //this.setAuthenticationToSecurityContext(authentication);
        return authentication;
    }

    public Long getJwtExpirationInMillisToAuthenticationResponse(){
        return jwtProvider.getJwtExpirationInMillis();
    }

    /*
    public Authentication authenticateByEmailAndPassword(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword());
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    public void setAuthenticationToSecurityContext(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

     */

}
