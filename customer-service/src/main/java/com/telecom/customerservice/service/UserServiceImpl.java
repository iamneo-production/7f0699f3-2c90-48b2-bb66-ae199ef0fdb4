package com.telecom.customerservice.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.customerservice.client.SelectedServiceProxy;
import com.telecom.customerservice.client.ServicesProxy;
import com.telecom.customerservice.entity.User;
import com.telecom.customerservice.exception.InvalidRequestException;
import com.telecom.customerservice.model.ServiceSelected;
import com.telecom.customerservice.model.Services;
import com.telecom.customerservice.model.UserDetail;
import com.telecom.customerservice.model.UserRequest;
import com.telecom.customerservice.model.UserResponse;
import com.telecom.customerservice.model.UserServiceResponse;
import com.telecom.customerservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ServicesProxy serviceProxy;
    
    @Autowired
    private SelectedServiceProxy selectedServiceProxy;
    
    
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

	@Override
	public List<Services> viewServices() {
		List<Services> ls = serviceProxy.viewServices();
		return ls;
	}

	@Override
	public String saveselectedServcie(String userId, Services service) {
		return selectedServiceProxy.saveSelectedService(userId,service);
	}

	@Override
	public List<ServiceSelected> viewMySelectedServices(String userId) {
		return selectedServiceProxy.viewSelectedServices(userId);
	}

	@Override
	public String updateselectedServcie(String userId, Services service) {
		return selectedServiceProxy.updateselectedServcie(userId,service);
	}

	@Override
	public String deleteselectedServcie(String userId, Services service) {
		return selectedServiceProxy.deleteselectedServcie(userId,service);
	}

}
