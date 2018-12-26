package com.auma.deinwagen.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.auma.deinwagen.model.Model;


	public interface VehicleRepository extends CrudRepository<Model, Integer> {

		
		List<Model> findByModelName(String modelName);

		List<Model> findAll();
		
		 
		

	}