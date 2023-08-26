package com.telecom.authenticationservice.service;

import com.telecom.authenticationservice.client.UserAPI;
import com.telecom.authenticationservice.client.model.User;
import com.telecom.authenticationservice.exception.ClientException;
import com.telecom.authenticationservice.exception.InvalidRequestException;
import com.telecom.authenticationservice.exception.TokenException;
import com.telecom.authenticationservice.model.AuthRequest;
import com.telecom.authenticationservice.model.ResponseDto;
import com.telecom.authenticationservice.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserAPI apiService;

    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    @Override
    public Token generateAccessToken(String userId) {
        Key hmacKey = getKey();

        String jwtToken = Jwts.builder()
                .claim("userId", userId)
                .setSubject(userId)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(15L, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();

        if(jwtToken == null) {
            throw new TokenException("Unable to generate JWT token");
        }

        Token token = new Token();
        token.setAccessToken(jwtToken);

        return token;
    }

    @Override
    public boolean validateUser(AuthRequest request) {
        if(Objects.isNull(request) || StringUtils.isBlank(request.getUserId()) || StringUtils.isBlank(request.getPassword())) {
            throw new InvalidRequestException("Invalid User Request");
        }

        ResponseEntity<ResponseDto<User>> clientResponse = apiService.getUser(request.getUserId());

        if(clientResponse == null || clientResponse.getBody() == null || clientResponse.getBody().getData() == null) {
            throw new ClientException("No Data returned in User API");
        }

        User user = clientResponse.getBody().getData();

        if(!user.getPassword().equals(request.getPassword())) {
            throw new InvalidRequestException("Password Mismatch");
        }
        return true;
    }

    private Key getKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());
    }

    @Override
    public String validateAccessToken(String token) {
        Key hmacKey = getKey();

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);

        if(jwt == null || jwt.getBody() == null || jwt.getBody().get("userId") == null) {
            throw new TokenException("Access token is invalid");
        }
        return jwt.getBody().get("userId").toString();
    }
}
