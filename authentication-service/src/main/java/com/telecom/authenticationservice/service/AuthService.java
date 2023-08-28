package com.telecom.authenticationservice.service;

import com.telecom.authenticationservice.model.AuthRequest;
import com.telecom.authenticationservice.model.Token;

public interface AuthService{
    Token generateAccessToken(String userId);

    boolean validateUser(AuthRequest request);

    String validateAccessToken(String token);
}
