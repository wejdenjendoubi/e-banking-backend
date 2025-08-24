package com.example.ebankig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.ebankig", "com.example.controllers"})

public class EbankigApplication {
	public static void main(String[] args) {
		SpringApplication.run(EbankigApplication.class, args);
	}
}
