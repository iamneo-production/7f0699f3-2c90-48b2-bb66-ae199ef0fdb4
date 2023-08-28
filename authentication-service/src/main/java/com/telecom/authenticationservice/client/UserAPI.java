package com.telecom.authenticationservice.client;

import com.telecom.authenticationservice.client.model.User;
import com.telecom.authenticationservice.model.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name= "customer-service")
public interface UserAPI {
    @GetMapping("/api/customer-profile/customer/{userId}")
    ResponseEntity<ResponseDto<User>> getUser(@PathVariable String userId);
}
