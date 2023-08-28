package com.telecom.customerservice.service;

import java.util.List;

import com.telecom.customerservice.model.ServiceSelected;
import com.telecom.customerservice.model.Services;
import com.telecom.customerservice.model.UserRequest;
import com.telecom.customerservice.model.UserResponse;
import com.telecom.customerservice.model.UserServiceResponse;


public interface UserService {
    void registerUser(UserRequest userRequest);

    UserResponse getUser(String userId);

    UserServiceResponse getUserWithService(String userId);

    List<Services> viewServices();

	String saveselectedServcie(String userId, Services service);

	List<ServiceSelected> viewMySelectedServices(String userId);

	String updateselectedServcie(String userId, Services service);

	String deleteselectedServcie(String userId, Services service);
}
