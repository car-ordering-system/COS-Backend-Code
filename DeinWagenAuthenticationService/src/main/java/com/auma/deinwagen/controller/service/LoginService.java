package com.auma.deinwagen.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auma.deinwagen.model.LoginDetail;
import com.auma.deinwagen.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository repository;
	
	public boolean validateUser(String username, String password) {
		
		List<LoginDetail> logindetail= repository.findByUserName(username);
		
		return username.equalsIgnoreCase(logindetail.get(0).getUserName())
				&& password.equalsIgnoreCase(logindetail.get(0).getPassword());
	}


}
