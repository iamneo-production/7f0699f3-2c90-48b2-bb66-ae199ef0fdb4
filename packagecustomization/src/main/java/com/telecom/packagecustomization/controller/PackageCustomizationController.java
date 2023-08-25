package com.telecom.packagecustomization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.telecom.packagecustomization.util.PackageLoader;
import com.telecom.packagecustomization.model.Packages;

@RestController
@RequestMapping("/package/")
public class PackageCustomizationController {


    @GetMapping("/availableServices")
    public List<Packages> getAvailableServices() {
        PackageLoader packageLoader = new PackageLoader();
        return packageLoader .loadPackages();
    }
}
