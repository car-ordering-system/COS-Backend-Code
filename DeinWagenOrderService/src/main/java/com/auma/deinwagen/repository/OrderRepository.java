package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.auma.deinwagen.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	
	 
	public List<Order> findByOrderId(int orderId);
	
	public List<Order> findByTransactionId(int transactionId);
	

}
