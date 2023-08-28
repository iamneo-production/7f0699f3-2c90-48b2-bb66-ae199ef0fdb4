package com.Hackathon.Services.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hackathon.Services.modal.Services;

@Repository
public interface TelecomServiceRepo extends JpaRepository<Services, Integer> {

	

}
