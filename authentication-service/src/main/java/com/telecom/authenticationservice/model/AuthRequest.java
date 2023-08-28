package com.telecom.authenticationservice.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String userId;
    private String password;
}
