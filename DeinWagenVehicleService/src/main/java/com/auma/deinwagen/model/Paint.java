package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Entity class for vehicle's paint .
 * This class holds for both internal and external paint
 *
 */
@Entity
@Table(name = "vehicle_paint")
@Component
public class Paint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paintId;
	@Column(name = "PAINT_NAME")
	private String paintName;
	@Column(name = "PAINT_TYPE")
	private String paintType;
	@Column(name = "MODEL_ID")
	private int modelId;
	@Column(name = "PRICE")
	private int paintPrice;
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	@Column(name = "LAST_UPDATED_TIME")
	private String lastUpdatedTime;

	public int getPaintId() {
		return paintId;
	}

	public void setPaintId(int paintId) {
		this.paintId = paintId;
	}

	public String getPaintName() {
		return paintName;
	}

	public void setPaintName(String paintName) {
		this.paintName = paintName;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getPaintPrice() {
		return paintPrice;
	}

	public void setPaintPrice(int paintPrice) {
		this.paintPrice = paintPrice;
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
