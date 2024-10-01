package com.batedesigns.auth_service.service;

import com.batedesigns.auth_service.model.Auth;
import com.batedesigns.auth_service.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String saveUser(Auth auth) {
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        authRepository.save(auth);
        return "user created in the system";
    }

    public String generateToken(String username) {
        log.info("Token for {} generated", username);
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
