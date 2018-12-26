package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.auma.deinwagen.model.Equipment;
import com.auma.deinwagen.model.Model;
import com.auma.deinwagen.model.Paint;

public interface VehicleEquipmentRepository extends CrudRepository<Equipment, Integer> {
	
	public Equipment findByEquipmentId (int equipmentId);

}
