package com.telecom.customerservice.model;

import lombok.Data;

@Data
public class UserServiceSelections {
    private int serviceId;

    private String serviceName;

    private int basePrice;

    private String validity;

    private String totaldata;

    private String voice;

    private int sms;
}
