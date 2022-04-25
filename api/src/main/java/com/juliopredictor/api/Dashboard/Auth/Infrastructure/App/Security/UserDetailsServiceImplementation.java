package com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security;

import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static java.util.Collections.singletonList;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserDao userDao;
    private final static Boolean ACCOUNT_NOT_EXPIRED = Boolean.TRUE;
    private final static Boolean CREDENTIAL_NOT_EXPIRED = Boolean.TRUE;
    private final static Boolean ACCOUNT_NOT_LOCKED = Boolean.TRUE;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        UserEntity userEntityFound = userDao.findFirstByEmail(email).orElseThrow(() -> new RuntimeException("No user found with email"));
        return new org.springframework.security.core.userdetails.User(
                userEntityFound.getEmail(),
                userEntityFound.getPassword(),
                userEntityFound.getEnable(),
                ACCOUNT_NOT_EXPIRED,
                CREDENTIAL_NOT_EXPIRED,
                ACCOUNT_NOT_LOCKED,
                getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }

}