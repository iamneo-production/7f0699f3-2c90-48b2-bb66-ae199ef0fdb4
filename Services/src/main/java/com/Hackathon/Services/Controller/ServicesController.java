package com.Hackathon.Services.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackathon.Services.modal.Services;
import com.Hackathon.Services.serviceImpl.TelecomServiceImpl;

@RestController
@RequestMapping("/Services")
public class ServicesController {
	
	@Autowired
	private TelecomServiceImpl telecomService;

	
	
	//URL : Post - http://localhost:8080/Services/addServices
	
			/* {
		        "serviceName": "Monthly",
		        "basePrice": 199,
		        "validity": "28 Days",
		        "totaldata": "1 GB/Day",
		        "voice": "Unlimited",
		        "sms": 300
		    } */
	@PostMapping("/addServices")	
	public String addService(@RequestBody Services service)
	{
		telecomService.addService(service);
		if(service.getServiceName()!=null)
		{
			return "Service Added Successfully";
		}
		else
		{
			return "Sorry, Something went wrong please try again";
		}
	}
	
	
	//URL : Get - http://localhost:8080/Services/viewServices
	@GetMapping("/viewServices")
	public List<Services> viewServices()
	{
		return telecomService.viewServices();
	}
	
	
	
	
	//URL : Post - http://localhost:8080/Services/editService/102
	/* {
		    "serviceName": "Monthly",
		    "basePrice": 199,
		    "validity": "28 Days",
		    "totaldata": "2 GB/Day",          --changed from 1GB to 2Gb
		    "voice": "Unlimited",
		    "sms": 300
	} */
	@PostMapping("/editService/{serviceId}")
	public String editService(@PathVariable int serviceId,@RequestBody Services service)
	{
		telecomService.editService(serviceId,service);
		if(service.getServiceName()!=null)
		{
			return "Service Updated Successfully";
		}
		else
		{
			return "Sorry, Something went wrong please try again";
		}
	}
	
	
	
	//URL : Get - http://localhost:8080/Services/findServiceById/102
	@GetMapping("/findServiceById/{serviceId}")
	public Services findServiceById (@PathVariable int serviceId)
	{
		return telecomService.findServiceById (serviceId);
		
	}
	
	
	//URL : Delete - http://localhost:8080/Services/deleteServiceById/102
	@DeleteMapping("/deleteServiceById/{serviceId}")
	public String deleteServiceById(@PathVariable int serviceId)
	{
		return telecomService.deleteServiceById (serviceId);
		
	}
}
