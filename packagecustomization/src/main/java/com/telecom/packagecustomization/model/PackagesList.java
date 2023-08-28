package com.telecom.packagecustomization.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PackagesList")
public class PackagesList {
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_;
    private int planid;
    private String planName;
    private int planAmount;
    private String planType;
    private String validity;
    private String dataVolume;
    private String voiceEligibility;
    private String smsEligbility;
    private String network;
}
