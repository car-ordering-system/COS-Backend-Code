package com.auma.deinwagen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableEurekaClient
@SpringBootApplication
public class DeinWagenVehicleServiceApplication {

	
	private static final Logger logger = LoggerFactory.getLogger(DeinWagenVehicleServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DeinWagenVehicleServiceApplication.class, args);
		logger.debug("Running *********** DeinWagenVehicleServiceApplication**********");
	}
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200")
	                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE")
	                .exposedHeaders("Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization")
	                .allowedHeaders("*");
	            }
	        };
	    }
}
