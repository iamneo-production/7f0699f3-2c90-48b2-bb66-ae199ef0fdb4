package com.telecom.pricingandbilling.service;

import java.util.List;
import com.telecom.pricingandbilling.model.Package;

public interface PricingAndBillingService {
	
	public double calculateFinalPrice(List<Package> packages);
}
