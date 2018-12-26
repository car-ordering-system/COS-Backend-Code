package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.auma.deinwagen.model.Paint;
import com.auma.deinwagen.model.VehicleTransaction;

public interface VehiclePaintRepository extends CrudRepository<Paint, Integer>{
	
	public List<Paint> findByPaintId (int paintId);

}
