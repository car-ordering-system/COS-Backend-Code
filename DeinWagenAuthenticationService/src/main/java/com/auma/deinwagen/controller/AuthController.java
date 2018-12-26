package com.auma.deinwagen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.auma.deinwagen.controller.service.LoginService;
import com.auma.deinwagen.model.LoginDetail;
import com.auma.deinwagen.security.jwt.TokenAuthenticationService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;




/**
 * 
 * Controller class to validate user and pass on JWT token in response
 * @author sphilipo
 *
 */
@CrossOrigin
@SessionAttributes("name")
@RestController
public class AuthController
{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	LoginService service;
	
	
	
	@Autowired
	TokenAuthenticationService  tokenAuthService;

	/*RestTemplate template;*/
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginDetail> validatelogin(@RequestParam String name, @RequestParam String password) {
		logger.info("Validating user");
		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			return new ResponseEntity<LoginDetail>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<LoginDetail>(HttpStatus.ACCEPTED);
		}
	}
	
	

}
