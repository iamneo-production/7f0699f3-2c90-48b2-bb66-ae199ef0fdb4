package com.telecom.authenticationservice.controller;

import com.telecom.authenticationservice.model.AuthRequest;
import com.telecom.authenticationservice.model.ResponseDto;
import com.telecom.authenticationservice.model.Token;
import com.telecom.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDto<Token>> authenticate(@RequestBody AuthRequest authRequest) {

        //validate request by checking in DB
        authService.validateUser(authRequest);

        // generate access token
        Token token = authService.generateAccessToken(authRequest.getUserId());

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(token));

    }

    @PostMapping("/validate")
    public ResponseEntity<ResponseDto<String>> validateToken(@RequestBody String accessToken) {

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(authService.validateAccessToken(accessToken)));

    }
}
