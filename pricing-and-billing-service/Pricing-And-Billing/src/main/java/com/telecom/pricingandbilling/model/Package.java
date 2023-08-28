package com.telecom.pricingandbilling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Package {
	private Integer planId;
	private String planName;
	private double planAmount;
	private String planType;
	private String validity;
	private String dataVolume;
	private String voiceEligibility;
	private String smsEligbility;
	private String network;
}
