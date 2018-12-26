package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

/**
 * Entity class for vehicle's model .
 *
 */

@Entity
@Table(name="vehicle_model")
@ComponentScan("com.auma.deinwagen.model")
public class Model {
	
	
	/**
	 * unique generated id for model
	 */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="model_id")
	private int modelId;
	
	/**
	 * Name of the model
	 */
	@Column(name="model_name")
	private String modelName;
	
	/**
	 * last updated userid
	 */
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	/**
	 * last updated time
	 */
	@Column(name="last_updated_time")
	private String lastUpdatedTime;
	
	public int getModelId() {
		return modelId;
	}
	
	
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
