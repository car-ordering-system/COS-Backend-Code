package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "vehicle_engine")
@Component
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "engine_id")
	private int engineId;

	@Column(name = "engine_name")
	private String engineName;

	@Column(name = "model_id")
	private int modelId;

	@Column(name = "engine_price")
	private int enginePrice;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_time")
	private String lastUpdatedTime;

	public int getEngineId() {
		return engineId;
	}

	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getEnginePrice() {
		return enginePrice;
	}

	public void setEnginePrice(int enginePrice) {
		this.enginePrice = enginePrice;
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
