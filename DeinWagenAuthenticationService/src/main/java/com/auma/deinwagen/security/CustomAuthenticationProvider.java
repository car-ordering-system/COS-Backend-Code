package com.auma.deinwagen.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.auma.deinwagen.model.LoginDetail;
import com.auma.deinwagen.repository.LoginRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	LoginRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		List<LoginDetail> logindetail = repository.findByUserName(name);

		logger.info("Name = " + name + " ,Password = " + password);

		// use the credentials and authenticate against the third-party system
		if (logindetail != null && !logindetail.isEmpty()) {
			if (name.equalsIgnoreCase(logindetail.get(0).getUserName())
					&& password.equalsIgnoreCase(logindetail.get(0).getPassword())) {
				logger.info("***************Succesful authentication!");
				return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
			}
		}

		else {
			logger.info("******Login failed!");
			throw new UsernameNotFoundException("Invalid Login");
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// return authentication.equals(UsernamePasswordAuthenticationToken.class);
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}