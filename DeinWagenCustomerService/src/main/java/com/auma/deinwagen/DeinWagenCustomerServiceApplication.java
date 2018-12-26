package com.auma.deinwagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@EnableEurekaClient
@SpringBootApplication
public class DeinWagenCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeinWagenCustomerServiceApplication.class, args);
	}
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200")
	                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE");
	            }
	        };
	    }
	 
}
