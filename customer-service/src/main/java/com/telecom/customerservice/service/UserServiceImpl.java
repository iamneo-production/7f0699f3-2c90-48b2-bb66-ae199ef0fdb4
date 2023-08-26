package com.telecom.customerservice.service;

import com.telecom.customerservice.entity.User;
import com.telecom.customerservice.exception.ClientException;
import com.telecom.customerservice.exception.InvalidRequestException;
import com.telecom.customerservice.model.*;
import com.telecom.customerservice.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void registerUser(UserRequest user) {
        validateUser(user);
        User existingUser = userRepository.findByUserId(user.getUserId());
        if(existingUser != null) {
            throw new InvalidRequestException("UserId is already Exist");
        }
        // StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // encryptor.setPassword(secret);
        // String encryptedPassword = encryptor.encrypt(user.getPassword());
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setUserId(user.getUserId());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userRepository.save(userEntity);
    }

    @Override
    public UserResponse getUser(String userId) {
        User user = validateAndGetUser(userId);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUserId(user.getUserId());
        userResponse.setPassword(user.getPassword());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

    @Override
    public UserServiceResponse getUserWithService(String userId) {
        User user = validateAndGetUser(userId);
        UserServiceResponse userDetailResponse = new UserServiceResponse();
        UserDetail userDetail = new UserDetail();
        userDetail.setName(user.getName());
        userDetail.setUserId(user.getUserId());
        userDetailResponse.setUser(userDetail);
       /* ResponseDto<List<UserServiceSelections>> userSelectedSevices = client.getUserServices(user.getUserId());
        if(userSelectedSevices == null) {
            throw new ClientException("Failed in Transaction API");
        }
        userDetailResponse.setServiceSelected(userSelectedSevices.getData());*/
        return userDetailResponse;
    }
    private void validateUser(UserRequest user) {
        if(user == null || StringUtils.isBlank(user.getUserId()) ||
                StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
            throw new InvalidRequestException("Invalid User Request");
        }
    }

    private User validateAndGetUser(String userId) {
        if(StringUtils.isBlank(userId)) {
            throw new InvalidRequestException("Invalid User Id");
        }
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new InvalidRequestException("No User Found for User Id : " + userId);
        }
        return user;
    }

}
