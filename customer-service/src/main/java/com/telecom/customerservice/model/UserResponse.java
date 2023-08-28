package com.telecom.customerservice.model;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;
    private String name;
    private String password;
    private String role;
}
