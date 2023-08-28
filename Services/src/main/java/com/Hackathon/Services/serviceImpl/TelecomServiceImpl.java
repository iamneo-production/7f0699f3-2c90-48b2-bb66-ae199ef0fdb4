package com.Hackathon.Services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackathon.Services.Repo.TelecomServiceRepo;

import com.Hackathon.Services.service.TelecomService;
import com.Hackathon.Services.modal.Services;

@Service
public class TelecomServiceImpl implements TelecomService {

	@Autowired
	private TelecomServiceRepo telecomServiceRepo;
	
	@Override
	public void addService(Services service) {
		telecomServiceRepo.save(service);
	}

	public List<Services> viewServices() {
		 List<Services> ls= telecomServiceRepo.findAll();
		 System.out.println(ls);
		return ls;
	}

	public void editService(int serviceId, Services service) {
		service.setServiceId(serviceId);
		telecomServiceRepo.save(service);
	}

	public Services findServiceById(int serviceId) {
		Services service = telecomServiceRepo.findById(serviceId).get();
		return service;
	}

	public String deleteServiceById(int serviceId) {
		try {
			Services service = telecomServiceRepo.findById(serviceId).get();
			telecomServiceRepo.delete(service);
			return "Sevice Deleted Successfully";
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured" + e);
		}
		return "Couldn't Delete the Service....Please Try Again";
	}

}
