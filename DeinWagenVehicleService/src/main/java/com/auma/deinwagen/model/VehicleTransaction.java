package com.auma.deinwagen.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "vehicle_transaction")
@ComponentScan("com.auma.deinwagen.model")
public class VehicleTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int transactionId;

	@Column(name = "CUST_ID")
	private int customerId;
	@Column(name = "LINE_ID")
	private int lineId;
	@Column(name = "MODEL_ID")
	private int modelId;
	@Column(name = "BODY_ID")
	private int bodyId;
	@Column(name = "ENGINE_ID")
	private int engineId;
	@Column(name = "EQUIPMENT_ID")
	private String equipmentId;
	@Column(name = "INT_PAINT_ID")
	private int intPaintId;
	@Column(name = "EXT_PAINT_ID")
	private int extPaintId;
	@Column(name = "DISCOUNT")
	private int discount;
	@Column(name = "TOTAL_PRICE")
	private int totalPrice;
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	@Column(name = "last_updated_time")
	private Timestamp lastUpdatedTime;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getBodyId() {
		return bodyId;
	}

	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}

	public int getEngineId() {
		return engineId;
	}

	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getIntPaintId() {
		return intPaintId;
	}

	public void setIntPaintId(int intPaintId) {
		this.intPaintId = intPaintId;
	}

	public int getExtPaintId() {
		return extPaintId;
	}

	public void setExtPaintId(int extPaintId) {
		this.extPaintId = extPaintId;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	

}
