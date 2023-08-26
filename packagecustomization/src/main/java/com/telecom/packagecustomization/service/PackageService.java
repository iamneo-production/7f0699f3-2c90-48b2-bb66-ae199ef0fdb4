import com.telecom.packagecustomization.service;

import com.telecom.packagecustomization.model.PackagesList;

import java.util.List;

public interface PackageService {
    
    PackagesList savePackage(PackagesList PackagesList);

    List<PackagesList> fetchPackageList();

    void deletPackageById(Long id);
}
