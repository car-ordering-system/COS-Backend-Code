package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Entity class for vehicle's Line or series .
 *
 */

@Entity
@Table(name = "vehicle_line")
@Component
public class Line {

	/**
	 * unique generated id for model
	 */
	@Column(name = "line_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int LineId;
	
	/**
	 * name of the line of car
	 */
	@Column(name = "LINE_NAME")
	private String LineName;
	
	/**
	 * model id of the car
	 */
	@Column(name = "MODEL_ID")
	private int modelId;
	
	/**
	 *  Id of the vehicle Engine 
	 */
	@Column(name = "ENGINE_ID")
	private int engineId;
	
	/**
	 * Price of the Line
	 */
	@Column(name = "PRICE")
	private int linePrice;
	
	/**
	 * UserId of the person who last updated the Line
	 */
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	/**
	 * last updated time
	 */
	@Column(name = "LAST_UPDATED_TIME")
	private String lastUpdatedTime;
	
	/**
	 * getters and setters
	 */

	public int getLineId() {
		return LineId;
	}

	public void setLineId(int lineId) {
		LineId = lineId;
	}

	public String getLineName() {
		return LineName;
	}

	public void setLineName(String lineName) {
		LineName = lineName;
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

	public int getLinePrice() {
		return linePrice;
	}

	public void setLinePrice(int linePrice) {
		this.linePrice = linePrice;
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
