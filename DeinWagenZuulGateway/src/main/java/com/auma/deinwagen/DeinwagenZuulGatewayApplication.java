package com.auma.deinwagen;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.auma.deinwagen.filters.ErrorFilter;
import com.auma.deinwagen.filters.PostFilter;
import com.auma.deinwagen.filters.PreFilter;
import com.auma.deinwagen.filters.RouteFilter;
import com.auma.deinwagen.filters.SimpleCORSFilter;
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class DeinwagenZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeinwagenZuulGatewayApplication.class, args);
	}
	
	
	 
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.addAllowedOrigin("http://localhost:4200");
	        configuration.addAllowedHeader("Access-Control-Request-Headers:Authorization");
	        configuration.addAllowedMethod("/**");
	        configuration.setAllowCredentials(true);
	        configuration.setMaxAge((long) 3600);
	        configuration.addExposedHeader("Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization");
	        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	       
	    }
	
	@Bean
	SimpleCORSFilter corsFilter() {
        SimpleCORSFilter filter = new SimpleCORSFilter();
        return filter;
    }


	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
