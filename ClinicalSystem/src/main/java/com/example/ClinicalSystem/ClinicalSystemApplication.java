package com.example.ClinicalSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
public class ClinicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalSystemApplication.class, args);
	}

}
