package com.auma.deinwagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DienwagenEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DienwagenEurekaServerApplication.class, args);
	}
}
