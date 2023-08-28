package com.Hackathon.Services.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Services {

	@Id
	@GeneratedValue
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int serviceId;
	
    private String serviceName;
  
    private int basePrice;
    
    private String validity;

    private String totaldata;

    private String voice;

    private int sms;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getTotaldata() {
		return totaldata;
	}

	public void setTotaldata(String totaldata) {
		this.totaldata = totaldata;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	
    
}
