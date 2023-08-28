package com.telecom.pricingandbilling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.pricingandbilling.model.Package;

@Service
public class PricingAndBillingServiceImplementation implements PricingAndBillingService {

	@Override
	public double calculateFinalPrice(List<Package> packages) {
		double totalAmount = 0.0;
		totalAmount = packages.stream().mapToDouble(Package::getPlanAmount).sum();
		return	totalAmount;
	}

}
