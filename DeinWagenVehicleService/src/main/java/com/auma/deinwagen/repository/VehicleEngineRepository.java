package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.auma.deinwagen.model.Engine;

public interface VehicleEngineRepository extends CrudRepository<Engine, Integer> {

	List<Engine> findByModelId(int modelId);

}
