package com.auma.deinwagen.repository;


import org.springframework.data.repository.CrudRepository;

import com.auma.deinwagen.model.LoginDetail;
import java.lang.String;
import java.util.List;

public interface LoginRepository extends CrudRepository<LoginDetail, Integer> {

	List<LoginDetail> findByUserName(String username);
}
