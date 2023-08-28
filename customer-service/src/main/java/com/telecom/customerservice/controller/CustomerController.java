<<<<<<< HEAD
package com.telecom.customerservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.customerservice.model.ResponseDto;
import com.telecom.customerservice.model.ServiceSelected;
import com.telecom.customerservice.model.Services;
import com.telecom.customerservice.model.UserRequest;
import com.telecom.customerservice.model.UserResponse;
import com.telecom.customerservice.model.UserServiceResponse;
import com.telecom.customerservice.service.UserService;

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
    
    @GetMapping("/customer/viewServices")
    public ResponseEntity<ResponseDto<List<Services>>> viewServices()
    {
    	 return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.viewServices()));
    }
    
    @PostMapping("/customer/selectServcie/{userId}")
    public ResponseEntity<ResponseDto<String>> saveselectedServcie(@PathVariable String userId, @RequestBody Services service)
    {
    	 return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.saveselectedServcie(userId,service)));
    }
    
    @GetMapping("/customer/viewMySelectedServices/{userId}")
    public ResponseEntity<ResponseDto<List<ServiceSelected>>> viewMySelectedServices(@PathVariable String userId)
    {
    	 return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.viewMySelectedServices(userId)));
    }
    
    @PostMapping("/customer/updateselectedServcie/{userId}")
    public ResponseEntity<ResponseDto<String>> updateselectedServcie(@PathVariable String userId, @RequestBody Services service)
    {
    	 return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.updateselectedServcie(userId,service)));
    }
    
    @DeleteMapping("/customer/deleteselectedServcie/{userId}")
    public ResponseEntity<ResponseDto<String>> deleteselectedServcie(@PathVariable String userId, @RequestBody Services service)
    {
    	 return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess( userService.deleteselectedServcie(userId,service)));
    }

    
}
=======
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
>>>>>>> 1154ea08bf9a1965144d2ac50ca7de90386cda8e
