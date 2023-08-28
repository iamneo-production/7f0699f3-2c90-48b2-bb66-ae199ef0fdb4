package com.telecom.packagecustomization.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Packages {
    private String planName;
    private int planAmount;
    private String planType;
    private String validity;
    private String dataVolume;
    private String voiceEligibility;
    private String smsEligbility;
    private String network;
}
