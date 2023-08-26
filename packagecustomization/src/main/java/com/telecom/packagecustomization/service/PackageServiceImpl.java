import com.telecom.packagecustomization.service;

import com.telecom.packagecustomization.model.PackagesList;
import com.telecom.packagecustomization.repo.PackageRepository;
import com.telecom.packagecustomization.service.PackageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl {
    
    @Autowired
    PackageRepository packageRepository;

    public PackagesList savePackage(PackagesList PackagesList) {
        return packageRepository.save(PackagesList);
    }

   public List<PackagesList> fetchPackageList() {
        return (List<PackagesList>) packageRepository.findAll();
    }

    public void deletPackageById(Long id) {
        packageRepository.deleteById(id);
    }

}
