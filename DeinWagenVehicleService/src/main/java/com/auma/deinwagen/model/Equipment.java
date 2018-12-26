package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * Entity Class for vehicle equipment
 *
 */
@Entity
@Table(name = "vehicle_equipment")
@Component
public class Equipment {

	/**
	 * Uniquely generated id for vehicle Equipment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int equipmentId;
	
	/**
	 * Name of the equipment
	 */
	@Column(name = "EQUIPMENT_NAME")
	private String equipmentName;
	/**
	 * Model Id with which equipment is associated
	 */
	@Column(name = "MODEL_ID")
	private int modelId;
	
	/**
	 * Engine with which equipment is associated
	 */
	@Column(name = "ENGINE_ID")
	private int engineId;
	/**
	 * Equipment Price
	 */
	@Column(name = "PRICE")
	private int equipmentPrice;
	
	/**
	 * User Id for the user who updated Equipment 
	 */
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	/**
	 * last updated time
	 */
	@Column(name = "LAST_UPDATED_TIME")
	private String lastUpdatedTime;

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getEngineId() {
		return engineId;
	}

	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	public int getEquipmentPrice() {
		return equipmentPrice;
	}

	public void setEquipmentPrice(int equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}
