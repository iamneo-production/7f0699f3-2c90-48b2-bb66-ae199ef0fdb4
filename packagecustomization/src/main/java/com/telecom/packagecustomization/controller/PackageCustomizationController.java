package com.telecom.packagecustomization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.telecom.packagecustomization.util.PackageLoader;
import com.telecom.packagecustomization.model.Packages;
import com.telecom.packagecustomization.model.PackagesList;
import com.telecom.packagecustomization.service.PackageServiceImpl;

@RestController
@RequestMapping("/package/")
public class PackageCustomizationController {

    @Autowired
    PackageServiceImpl packageService;

    @GetMapping("/availableServices")
    public List<Packages> getAvailableServices() {
        PackageLoader packageLoader = new PackageLoader();
        return packageLoader .loadPackages();
    }

    @GetMapping("/availablePackages")
    public List<PackagesList> getAvailablePackages() {
        return packageService.fetchPackageList();
    }

    @PostMapping("/packages")
    public PackagesList savePackage(@RequestBody PackagesList packagesList)
    {
        return packageService.savePackage(packagesList);
    }

    @DeleteMapping("/packages/{id}")
    public String deletPackageById(@PathVariable("id") Long id) {
        packageService.deletPackageById(id);
        return "Deleted Successfully";
    }
}
