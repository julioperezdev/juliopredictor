package com.juliopredictor.api.Shared.Infrastructure.Gateway;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpringFrameworkStringEncoder {

    private final PasswordEncoder passwordEncoder;

    public String encodeString(String stringToEncode){
        return passwordEncoder.encode(stringToEncode);
    }
}
