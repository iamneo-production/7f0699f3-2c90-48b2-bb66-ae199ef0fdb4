package com.telecom.customerservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.telecom.customerservice.model.Services;


@FeignClient(name="TELECOM-SERVICE")
public interface ServicesProxy {
	@GetMapping("/Services/viewServices")
	public List<Services> viewServices();

}
