package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.auma.deinwagen.model.VehicleTransaction;

public interface VehicleTransactionRepository extends CrudRepository<VehicleTransaction, Integer> {
	
	public List<VehicleTransaction> findByTransactionId(int transactionId);

}
