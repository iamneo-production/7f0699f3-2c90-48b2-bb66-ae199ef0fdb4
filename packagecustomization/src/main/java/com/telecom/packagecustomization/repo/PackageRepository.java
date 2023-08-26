package com.telecom.packagecustomization.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.packagecustomization.model.PackagesList;

@Repository
public interface PackageRepository extends JpaRepository<PackagesList, Long> {
    
}
