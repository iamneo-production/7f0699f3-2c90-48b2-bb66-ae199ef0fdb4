package com.telecom.customerservice.controller;

import com.telecom.customerservice.model.ResponseDto;
import com.telecom.customerservice.model.UserRequest;
import com.telecom.customerservice.model.UserResponse;
import com.telecom.customerservice.model.UserServiceResponse;
import com.telecom.customerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/customer-profile")
public class CustomerController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto<String>> register(@RequestBody UserRequest userRequest) {
        userService.registerUser(userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess("User Register Successfully"));
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<ResponseDto<UserResponse>> getUser(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.getUser(userId)));
    }

    @GetMapping("/customer-service/{userId}")
    public ResponseEntity<ResponseDto<UserServiceResponse>> getUserDetails(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.getUserWithService(userId)));
    }

}
