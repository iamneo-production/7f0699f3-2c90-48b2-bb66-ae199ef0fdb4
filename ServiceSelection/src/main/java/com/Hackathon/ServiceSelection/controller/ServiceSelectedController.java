package com.Hackathon.ServiceSelection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackathon.ServiceSelection.dto.Services;
import com.Hackathon.ServiceSelection.modal.ServiceSelected;
import com.Hackathon.ServiceSelection.serviceImpl.ServiceSelectedImpl;


@RestController
@RequestMapping("/ServiceSelected")
public class ServiceSelectedController {

	@Autowired
	ServiceSelectedImpl serviceSelected;
	
	@PostMapping("/saveService/{userId}")	
	public String saveSelectedService(@PathVariable("userId") String userId,@RequestBody Services service)
	{
		System.out.println("----------------" + userId);
		return serviceSelected.saveSelectedService(userId,service);
		
	}
	
	@GetMapping("/viewMySelectedServices/{userId}")	
	public List<ServiceSelected> viewMySelectedServices(@PathVariable("userId") String userId)
	{
		System.out.println("----------------" + userId);
		return serviceSelected.viewMySelectedServices(userId);
		
	}
	
	@PostMapping("/updateselectedServcie/{userId}")	
	public String updateselectedServcie(@PathVariable("userId") String userId, @RequestBody Services service)
	{
		return serviceSelected.updateselectedServcie(userId,service);
	}
	
	@DeleteMapping("/deleteselectedServcie/{userId}")
	public String deleteselectedServcie(@PathVariable("userId") String userId, @RequestBody Services service)
	{
		return serviceSelected.deleteselectedServcie(userId,service);
	}
}
