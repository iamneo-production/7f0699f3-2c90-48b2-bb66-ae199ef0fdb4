package com.telecom.customerservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.telecom.customerservice.model.ServiceSelected;
import com.telecom.customerservice.model.Services;




@FeignClient(name="SELECT-SERVICE")
public interface SelectedServiceProxy {

	@PostMapping("/ServiceSelected/saveService/{userId}")	
	public String saveSelectedService(@PathVariable("userId") String userId,@RequestBody Services service);

	@GetMapping("/ServiceSelected/viewMySelectedServices/{userId}")	
	public List<ServiceSelected> viewSelectedServices(@PathVariable("userId") String userId);

	@PostMapping("/ServiceSelected/updateselectedServcie/{userId}")	
	public String updateselectedServcie(@PathVariable("userId") String userId, @RequestBody Services service);

	@DeleteMapping("/ServiceSelected/deleteselectedServcie/{userId}")
	public String deleteselectedServcie(@PathVariable("userId") String userId, @RequestBody Services service);
}
