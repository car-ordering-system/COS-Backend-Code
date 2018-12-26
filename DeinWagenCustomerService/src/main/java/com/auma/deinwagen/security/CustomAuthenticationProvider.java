/*package com.auma.deinwagen.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.auma.deinwagen.model.LoginDetail;
import com.auma.deinwagen.repository.LoginRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	EurekaClient eurekaClient;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		logger.info("Name = " + name + " ,Password = " + password);

		// use the credentials and authenticate against the third-party system
		if (name.equalsIgnoreCase(logindetail.get(0).getUserName())
				&& password.equalsIgnoreCase(logindetail.get(0).getPassword())) {
			logger.info("***************Succesful authentication!");
			return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
		}
		
		 * if(("user".equals(name) && "user".equals(password)) || ("admin".equals(name)
		 * && "admin".equals(password))){
		 

		logger.info("******Login failed!");
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// return authentication.equals(UsernamePasswordAuthenticationToken.class);
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public ResponseEntity<> accessAuthenticationService(ModelMap model, @RequestParam String name, @RequestParam String password) {
		logger.info("Validating user");
		Application application = eurekaClient.getApplication("auth");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "vehicleBodyDetail";
        System.out.println("URL" + url);
        
        System.out.println("RESPONSE "  );
		return null;
 
}*/