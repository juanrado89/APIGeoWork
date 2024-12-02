package org.albertorado.apigeowork.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderProvider {

    private static PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncoderProvider(PasswordEncoder passwordEncoder) {
        PasswordEncoderProvider.passwordEncoder = passwordEncoder;
    }

    public static PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}

