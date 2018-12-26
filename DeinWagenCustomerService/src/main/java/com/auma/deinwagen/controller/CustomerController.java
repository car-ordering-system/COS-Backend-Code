package com.auma.deinwagen.controller;


import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auma.deinwagen.model.Customer;
import com.auma.deinwagen.model.CustomerModel;
import com.auma.deinwagen.repository.CustomerRepository;

/**
 * Controller class for DienWagenCustomerSerice
 *
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerRepository custService;

	/**
	 * The method returns the list of customers in DeinWagen system
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomerDetail() {
		List<Customer> customerList = (List<Customer>) custService.findAll();
		if (customerList != null && customerList.size() > 0)
			return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerModel customer) {
		Customer customerEntry=new Customer();
		customerEntry.setAddress(customer.getAddress());
		customerEntry.setCustName(customer.getCustName());
		customerEntry.setEmailId(customer.getEmailId());
		customerEntry.setMobileNo(customer.getMobileNo());
		customerEntry.setLastUpdatedBy(customer.getLastUpdatedBy());
		Timestamp timestamp=null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
			Date parsedDate = (Date) dateFormat.parse(customer.getLastUpdatedTime());
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch(Exception e) { //this generic but you can control another types of exception
			// look the origin of excption 
		}
		customerEntry.setLastUpdatedTime(timestamp);

		custService.save(customerEntry);
		return new ResponseEntity<Customer>(customerEntry, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/getCustomerByMobileNo", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomerByMobileNo(@RequestParam String mobileNo) {
		List<Customer> customerList = (List<Customer>) custService.findByMobileNo(mobileNo);
		if (customerList != null && customerList.size() > 0)
			return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	

	@CrossOrigin
	@RequestMapping(value = "/getCustomerByQuery", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomerByQuery(@RequestParam String customerId) {
		int custId=Integer.parseInt(customerId.trim());
		
		List<Customer> customerList = (List<Customer>) custService.findbySearch(custId);
		if (customerList != null && customerList.size() > 0)
			return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	
//	@CrossOrigin
//	@RequestMapping(value = "/getCustomerByQuery", method = RequestMethod.GET)
//	public ResponseEntity<List<Customer>> getCustomerByQuery(@RequestParam String customerId, @RequestParam String customerName, @RequestParam String emailAddress) {
//		int custId=Integer.parseInt(customerId.trim());
//		String custName=customerName.trim();
//		String emailId=emailAddress.trim();
//		List<Customer> customerList = (List<Customer>) custService.findbySearch(custId, custName, emailId);
//		if (customerList != null && customerList.size() > 0)
//			return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
//		else
//			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
//	}


}
