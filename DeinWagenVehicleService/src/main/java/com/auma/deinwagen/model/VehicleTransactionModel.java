package com.auma.deinwagen.model;

public class VehicleTransactionModel {
	
		
		private int transactionId;
		
		private int customerId;
		
		private int lineId;
		
		private int modelId;
		
		private int bodyId;
		
		private int engineId;
		
		private String equipmentId;
		
		private int intPaintId;
		
		private int extPaintId;
		
		private int discount;
		
		private int totalPrice;
		
		private String lastUpdatedBy;
		
		private String lastUpdatedTime;

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

		public String getLastUpdatedTime() {
			return lastUpdatedTime;
		}

		public void setLastUpdatedTime(String lastUpdatedTime) {
			this.lastUpdatedTime = lastUpdatedTime;
		}

	
}
