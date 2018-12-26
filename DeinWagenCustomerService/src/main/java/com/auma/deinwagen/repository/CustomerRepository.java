package com.auma.deinwagen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.auma.deinwagen.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
//	@Query("SELECT p FROM Customer p  where p.custId=custId  and custName like '%' and emailId like '%'")
//    public List<Customer> findbySearch(@Param("cust_id") int custId,@Param("cust_name") String custName, @Param("email_id") String emailId);
	
	@Query("SELECT p FROM Customer p  where p.custId=:cust_id")
    public List<Customer> findbySearch(@Param("cust_id") int custId);
	
	public List<Customer> findByMobileNo(String mobileNo);

}
