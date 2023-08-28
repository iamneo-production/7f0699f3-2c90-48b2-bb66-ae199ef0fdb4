package com.Hackathon.ServiceSelection.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Hackathon.ServiceSelection.Repo.serviceSelectedRepo;
import com.Hackathon.ServiceSelection.dto.Services;
import com.Hackathon.ServiceSelection.modal.ServiceSelected;

@Service
public class ServiceSelectedImpl {
	
	@Autowired
	serviceSelectedRepo serviceselectedRepo; 

	public String saveSelectedService(String customerId,@RequestBody Services service)
	{
		try
		{
			ServiceSelected ss = new ServiceSelected();
			ss.setUser_id(customerId);
			ss.setServiceId(service.getServiceId());
			ss.setServiceName(service.getServiceName());
			ss.setBasePrice(service.getBasePrice());
			ss.setValidity(service.getValidity());
			ss.setTotaldata(service.getTotaldata());
			ss.setVoice(service.getVoice());
			ss.setSms(service.getSms());
			
			serviceselectedRepo.save(ss);
			
			return "Service Selected Successfully";
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured" + e);
		}
		return "Couldn't Select the Service....Please Try Again";
	}

	public List<ServiceSelected> viewMySelectedServices(String userId) {
		List<ServiceSelected> ls= serviceselectedRepo.findAllById(userId);
		return ls;
	}

	public String updateselectedServcie(String userId, Services service) {
		try 
		{
			ServiceSelected ss = new ServiceSelected();
			ss.setUser_id(userId);
			ss.setServiceId(service.getServiceId());
			ss.setServiceName(service.getServiceName());
			ss.setBasePrice(service.getBasePrice());
			ss.setValidity(service.getValidity());
			ss.setTotaldata(service.getTotaldata());
			ss.setVoice(service.getVoice());
			ss.setSms(service.getSms());
			
			serviceselectedRepo.save(ss);
		
			return "Selected Service Updated Successfully";
		}
		catch (Exception e) {
			System.out.println("Exception Occured" + e);
		}
		return "Couldn't Update the Service....Please Try Again";
	}

	public String deleteselectedServcie(String userId, Services service) {
		try 
		{
			//serviceselectedRepo.deleteById(Integer.toString(service.getServiceId()));
			
			ServiceSelected ss = new ServiceSelected();
			ss.setUser_id(userId);
			ss.setServiceId(service.getServiceId());
			ss.setServiceName(service.getServiceName());
			ss.setBasePrice(service.getBasePrice());
			ss.setValidity(service.getValidity());
			ss.setTotaldata(service.getTotaldata());
			ss.setVoice(service.getVoice());
			ss.setSms(service.getSms());
			
			serviceselectedRepo.delete(ss);
		
			return "Selected Service Deleted Successfully";
		}
		catch (Exception e) {
			System.out.println("Exception Occured" + e);
		}
		return "Couldn't Delete the Service....Please Try Again";
	}
	
}
