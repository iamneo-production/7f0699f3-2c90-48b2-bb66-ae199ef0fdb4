package com.Hackathon.ServiceSelection.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Hackathon.ServiceSelection.modal.ServiceSelected;

@Repository
public interface serviceSelectedRepo extends JpaRepository<ServiceSelected, String> {

	@Query("SELECT p FROM ServiceSelected p WHERE p.user_id LIKE :user_id")
	List<ServiceSelected> findAllById(String user_id);

//	@Query("DELETE u FROM ServiceSelected u WHERE u.serviceId LIKE :serviceId")
//	void deleteselectedServcie(int serviceId);

}

