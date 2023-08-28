package com.telecom.pricingandbilling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.pricingandbilling.service.PricingAndBillingService;
import com.telecom.pricingandbilling.model.Package;

@RestController
@RequestMapping("/pricing")
public class PricingAndBillingController {
	
	private PricingAndBillingService pricingAndBillingService;
	
	@Autowired
	public PricingAndBillingController(PricingAndBillingService pricingAndBillingService) {
		super();
		this.pricingAndBillingService = pricingAndBillingService;
	}

	@PostMapping("/{customerId}")
	public Double calculateAmount(@PathVariable String customerId ,@RequestBody List<Package> packages) {
		return pricingAndBillingService.calculateFinalPrice(packages);
	}
}
