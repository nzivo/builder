package com.batedesigns.auth_service.service;

import com.batedesigns.auth_service.config.CustomUserDetails;
import com.batedesigns.auth_service.model.Auth;
import com.batedesigns.auth_service.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Auth> auth = authRepository.findByUsername(username);
        return auth.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
