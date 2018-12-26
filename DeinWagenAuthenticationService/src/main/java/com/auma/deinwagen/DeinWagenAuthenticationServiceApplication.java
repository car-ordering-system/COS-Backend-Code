package com.auma.deinwagen;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class DeinWagenAuthenticationServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(DeinWagenAuthenticationServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DeinWagenAuthenticationServiceApplication.class, args);
		logger.debug("Running *********** DeinWagenAuthenticationServiceApplication");
	}
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200")
	                .exposedHeaders("Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization")
	                .allowedHeaders("Access-Control-Allow-Origin")
	                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE");
	            }
	        };
	    }
}
