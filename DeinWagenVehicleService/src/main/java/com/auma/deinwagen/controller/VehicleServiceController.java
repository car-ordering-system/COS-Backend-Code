package com.auma.deinwagen.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auma.deinwagen.model.Body;

import com.auma.deinwagen.model.Engine;
import com.auma.deinwagen.model.Equipment;
import com.auma.deinwagen.model.Line;
import com.auma.deinwagen.model.Model;
import com.auma.deinwagen.model.Paint;
import com.auma.deinwagen.model.VehicleTransaction;
import com.auma.deinwagen.model.VehicleTransactionModel;
import com.auma.deinwagen.repository.VehicleBodyRepository;
import com.auma.deinwagen.repository.VehicleEngineRepository;
import com.auma.deinwagen.repository.VehicleEquipmentRepository;
import com.auma.deinwagen.repository.VehicleLineRepository;
import com.auma.deinwagen.repository.VehiclePaintRepository;
import com.auma.deinwagen.repository.VehicleRepository;
import com.auma.deinwagen.repository.VehicleTransactionRepository;



/**
 * @author sphilipo
 * Controller to access vehicle service resources
 *
 */
@RestController
public class VehicleServiceController {

	@Autowired
	VehicleRepository service;
	@Autowired
	VehicleLineRepository lineService;
	@Autowired
	VehicleEquipmentRepository equipmentService;
	@Autowired
	VehicleEngineRepository engineService;
	@Autowired
	VehiclePaintRepository paintService;
	@Autowired
	VehicleBodyRepository bodyService;
	@Autowired
	VehicleTransactionRepository transactionService;


	@CrossOrigin(origins="*", exposedHeaders="Authorization",methods= {RequestMethod.GET, RequestMethod.POST}, allowCredentials="true")
	@RequestMapping(value = "/modelDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Model>> getAllModelDetail() {
		List<Model> modelsAvailable=(List<Model>) service.findAll();
		if(modelsAvailable!=null && modelsAvailable.size()>0)	
			return new ResponseEntity<List<Model>>(modelsAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Model>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin(origins="*", exposedHeaders="Authorization")
	@RequestMapping(value = "/vehicleLineDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Line>> getVehicleLineDetail() {
		List<Line> linesAvailable=(List<Line>) lineService.findAll();
		if(linesAvailable!=null&& linesAvailable.size()>0)	
			return new ResponseEntity<List<Line>>(linesAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Line>>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/vehicleEquipmentDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Equipment>> getVehicleEquipmentDetail() {
		List<Equipment> equipmentsAvailable = (List<Equipment>) equipmentService.findAll();
		if (equipmentsAvailable != null && equipmentsAvailable.size()> 0)
			return new ResponseEntity<List<Equipment>>(equipmentsAvailable, HttpStatus.OK);
		else
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "unchecked"})
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/equipmentById", method = RequestMethod.GET)
	public ResponseEntity<List<Equipment>> getEquipmentById(@RequestParam String equipmentId) {
		//			int equipmentNo=Integer.parseInt(equipmentId.trim());
		List<Equipment> finalList=new ArrayList<Equipment>();
		List<String> myList = new ArrayList<String>(Arrays.asList(equipmentId.trim().split(",")));
		for(String my:myList) {
			Equipment equipment=equipmentService.findByEquipmentId(Integer.parseInt(my));
			finalList.add(equipment);
		}
		//			List<Equipment> paintList=(List<Equipment>)equipmentService.findByEquipmentId(equipmentNo);
		if(finalList!=null && finalList.size()>0)	
			return new ResponseEntity<List<Equipment>>(finalList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin(origins="*", exposedHeaders="Authorization")
	@RequestMapping(value = "/vehicleEngineDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Engine>> getVehicleEngineDetail() {
		List<Engine> enginesAvailable= (List<Engine>) engineService.findAll();
		if(enginesAvailable!=null&& enginesAvailable.size()>0)	
			return new ResponseEntity<List<Engine>>(enginesAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Engine>>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@RequestMapping(value = "/vehicleEnginebyModelId", method = RequestMethod.GET)
	public ResponseEntity<List<Engine>> getVehicleEnginesByModelId(int modelId) {
		List<Engine> enginesAvailable= (List<Engine>) engineService.findByModelId(modelId);
		if(enginesAvailable!=null&& enginesAvailable.size()>0)	
			return new ResponseEntity<List<Engine>>(enginesAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Engine>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin(origins="*", exposedHeaders="Authorization" )
	@RequestMapping(value = "/vehicleBodyDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Body>> getVehicleBodyDetail() {
		List<Body> modelsAvailable=(List<Body>) bodyService.findAll();
		if(modelsAvailable!=null&& modelsAvailable.size()>0)	
			return new ResponseEntity<List<Body>>(modelsAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Body>>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@RequestMapping(value = "/vehicleBodyByModelId", method = RequestMethod.GET)
	public ResponseEntity<List<Body>> getVehicleBodyByModelId(int modelId) {
		List<Body> modelsAvailable=(List<Body>) bodyService.findByModelId(modelId);
		if(modelsAvailable!=null&& modelsAvailable.size()>0)	
			return new ResponseEntity<List<Body>>(modelsAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Body>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin
	@RequestMapping(value = "/vehiclePaintDetail", method = RequestMethod.GET)
	public ResponseEntity<List<Paint>> getVehiclePaintDetail() {
		List<Paint> colorsAvailable=(List<Paint>) paintService.findAll();
		if(colorsAvailable!=null&& colorsAvailable.size()>0)	
			return new ResponseEntity<List<Paint>>(colorsAvailable,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Paint>>(HttpStatus.NO_CONTENT);
	}


	@CrossOrigin
	@RequestMapping(value = "/paintById", method = RequestMethod.GET)
	public ResponseEntity<List<Paint>> getPaintById(@RequestParam String paintId) {
		int paintNo=Integer.parseInt(paintId.trim());
		List<Paint> paintList=(List<Paint>)paintService.findByPaintId(paintNo);
		if(paintList!=null && paintList.size()>0)	
			return new ResponseEntity<List<Paint>>(paintList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<Paint>>(HttpStatus.NO_CONTENT);
	}

	@CrossOrigin  
	@RequestMapping(value = "/vehicleTransactionDetail", method = RequestMethod.GET)
	public ResponseEntity<List<VehicleTransaction>> getVehicleTransactionDetail() {
		List<VehicleTransaction> transactionList=(List<VehicleTransaction>) transactionService.findAll();
		if(transactionList!=null&& transactionList.size()>0)	
			return new ResponseEntity<List<VehicleTransaction>>(transactionList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<VehicleTransaction>>(HttpStatus.NO_CONTENT);
	}


	@CrossOrigin
	@RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<VehicleTransaction> saveTransaction(@RequestBody VehicleTransactionModel transactionModel) {
		VehicleTransaction request=new VehicleTransaction();
		request.setModelId(transactionModel.getModelId());
		request.setBodyId(transactionModel.getBodyId());
		request.setCustomerId(transactionModel.getCustomerId());
		request.setEngineId(transactionModel.getEngineId());
		request.setLineId(transactionModel.getLineId());
		request.setEquipmentId(transactionModel.getEquipmentId());
		request.setExtPaintId(transactionModel.getExtPaintId());
		request.setIntPaintId(transactionModel.getIntPaintId());
		request.setTotalPrice(transactionModel.getTotalPrice());
		Timestamp timestamp=null;

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
			Date parsedDate = (Date) dateFormat.parse(transactionModel.getLastUpdatedTime());
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch(Exception e) { //this generic but you can control another types of exception
			// look the origin of exception 
		}
		request.setLastUpdatedBy(transactionModel.getLastUpdatedBy());
		request.setLastUpdatedTime(timestamp);
		transactionService.save(request);
		return new ResponseEntity<VehicleTransaction>(request, HttpStatus.CREATED);
	}


	@CrossOrigin
	@RequestMapping(value = "/updateTransaction", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<VehicleTransaction> updateTransaction(@RequestBody VehicleTransactionModel transactionModel) {


		VehicleTransaction transactionAvailable=transactionService.findOne(transactionModel.getTransactionId());
		if (transactionAvailable==null)
			return ResponseEntity.notFound().build();
		else {
			VehicleTransaction request=new VehicleTransaction();
			request.setTransactionId(transactionModel.getTransactionId());
			request.setModelId(transactionModel.getModelId());
			request.setBodyId(transactionModel.getBodyId());
			request.setCustomerId(transactionModel.getCustomerId());
			request.setEngineId(transactionModel.getEngineId());
			request.setLineId(transactionModel.getLineId());
			request.setEquipmentId(transactionModel.getEquipmentId());
			request.setExtPaintId(transactionModel.getExtPaintId());
			request.setIntPaintId(transactionModel.getIntPaintId());
			request.setTotalPrice(transactionModel.getTotalPrice());
			Timestamp timestamp=null;

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
				Date parsedDate = (Date) dateFormat.parse(transactionModel.getLastUpdatedTime());
				timestamp = new java.sql.Timestamp(parsedDate.getTime());
			} catch(Exception e) { //this generic but you can control another types of exception
				// look the origin of excption 
			}
			request.setLastUpdatedBy(transactionModel.getLastUpdatedBy());
			request.setLastUpdatedTime(timestamp);
			transactionService.save(request);
			return new ResponseEntity<VehicleTransaction>(request, HttpStatus.CREATED);

		}	
	}


	@CrossOrigin
	@RequestMapping(value = "/transactionById", method = RequestMethod.GET)
	public ResponseEntity<List<VehicleTransaction>> getOrderById(@RequestParam String transactionId) {
		int transactionNo=Integer.parseInt(transactionId.trim());
		List transactionList=transactionService.findByTransactionId(transactionNo);
		if(transactionList!=null && transactionList.size()>0)	
			return new ResponseEntity<List<VehicleTransaction>>(transactionList,HttpStatus.OK);
		else 
			return new ResponseEntity<List<VehicleTransaction>>(HttpStatus.NO_CONTENT);
	}

}
