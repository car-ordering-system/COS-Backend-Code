package com.auma.deinwagen.model;

import org.springframework.stereotype.Component;

@Component
public class VehicleDetail {

	private String id;
	private String vehicleName;

	public VehicleDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleDetail(String id, String vehicleName) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
