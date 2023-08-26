package com.telecom.customerservice.service;

import com.telecom.customerservice.model.UserRequest;
import com.telecom.customerservice.model.UserResponse;
import com.telecom.customerservice.model.UserServiceResponse;

public interface UserService {
    void registerUser(UserRequest userRequest);

    UserResponse getUser(String userId);

    UserServiceResponse getUserWithService(String userId);
}
