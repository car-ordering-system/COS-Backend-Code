package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.auma.deinwagen.model.Body;
import com.auma.deinwagen.model.Model;

public interface VehicleBodyRepository extends CrudRepository<Body, Integer> {

	List<Body> findByModelId(int modelId);
	

}
