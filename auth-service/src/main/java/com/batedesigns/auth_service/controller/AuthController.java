package com.batedesigns.auth_service.controller;

import com.batedesigns.auth_service.dto.AuthRequest;
import com.batedesigns.auth_service.model.Auth;
import com.batedesigns.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewUser(@RequestBody Auth auth) {
        return authService.saveUser(auth);
    }

    @PostMapping("/token")
    @ResponseStatus(HttpStatus.OK)
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getUsername());
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

    }

    @GetMapping("/validate-token")
    @ResponseStatus(HttpStatus.OK)
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }
}