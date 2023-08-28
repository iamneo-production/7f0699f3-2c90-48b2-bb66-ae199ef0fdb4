package com.telecom.authenticationservice.client.model;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String name;
    private String password;
}
