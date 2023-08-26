package com.telecom.packagecustomization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan(basePackages = "com.telecom.packagecustomization.model")
@EnableJpaRepositories(basePackages = "com.telecom.packagecustomization.repo")
public class PackagecustomizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagecustomizationApplication.class, args);
	}

}
