package com.auma.deinwagen.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.auma.deinwagen.model.Order;
import com.auma.deinwagen.model.OrderModel;
import com.auma.deinwagen.repository.OrderRepository;
import com.netflix.discovery.EurekaClient;

@RestController
public class OrderController {


	@Autowired
	OrderRepository orderService;
	
	@CrossOrigin
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAllOrderDetail() {
		
		List<Order> allOrders=(List<Order>) orderService.findAll();
		if(allOrders!=null && allOrders.size()>0)	
			return new ResponseEntity<List<Order>>(allOrders,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@RequestMapping(value = "/ordersById", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrderById(@RequestParam String orderId) {
		int orderNo=Integer.parseInt(orderId.trim());
		List orderList=orderService.findByOrderId(orderNo);
		if(orderList!=null && orderList.size()>0)	
			return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/ordersByTransactionId", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrderByTransactionId(@RequestParam String transactionId) {
		int transactionNo=Integer.parseInt(transactionId.trim());
		List orderList=orderService.findByTransactionId(transactionNo);
		if(orderList!=null && orderList.size()>0)	
			return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
	}



	@CrossOrigin
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Order> addOrder(@RequestBody OrderModel order) {
		Order orderEntry=new Order();
		Timestamp timestamp=null;
		Date actualDDate=new Date();
		Date estDate=new Date();
		Date orderDate = new Date(); 
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
			Date parsedDate = (Date) dateFormat.parse(order.getLastUpdatedTime());
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
			actualDDate=(Date) dateFormat.parse(order.getActualDeliveryDate());
			estDate=(Date) dateFormat.parse(order.getEstDeliveryDate());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		     
		    System.out.println(formatter.format(orderDate));  
		} catch(Exception e) { //this generic but you can control another types of exception
			// look the origin of excption 
		}

		orderEntry.setActualDeliveryDate(actualDDate);
		orderEntry.setEstDeliveryDate(estDate);
		orderEntry.setOrderDate(orderDate);
		orderEntry.setOrderStatus(order.getOrderStatus());
		orderEntry.setTotalPrice(order.getTotalPrice());
		orderEntry.setTransactionId(Integer.parseInt(order.getTransactionId()));
		orderEntry.setLastUpdatedBy(order.getLastUpdatedBy());
		orderEntry.setLastUpdatedTime(timestamp);

		orderService.save(orderEntry);
		return new ResponseEntity<Order>(orderEntry, HttpStatus.CREATED);
	}


	
}
