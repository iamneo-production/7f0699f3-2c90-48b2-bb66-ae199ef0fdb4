package com.telecom.customerservice.model;

import lombok.Data;

import java.util.List;
@Data
public class UserServiceResponse {
    private UserDetail user;
    private List<UserServiceSelections> serviceSelected;
}
