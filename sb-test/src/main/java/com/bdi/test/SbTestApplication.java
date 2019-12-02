package com.bdi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bdi.test"})	
public class SbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbTestApplication.class, args);
	}

}
