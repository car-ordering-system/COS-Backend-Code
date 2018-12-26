package com.auma.deinwagen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;


/**
 * @author sphilipo
 * Entity class for dealer_details table
 *
 */
@Entity
@Table(name = "DEALER_DETAILS")
@ComponentScan("com.auma.deinwagen.model")
public class DealerDetail {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int dealerId;

		@Column(name = "DEALER_NAME")
		private String dealerName;

		@Column(name = "ADDRESS")
		private String address;
		
		@Column(name = "EMAIL_ID")
		private String emailId;

		@Column(name = "last_updated_by")
		private String lastUpdatedBy;
			
		@Column(name = "last_updated_time")
		private String lastUpdatedTime;
		
		//getters and setters
			
		public int getDealerId() {
			return dealerId;
		}

		public void setDealerId(int dealerId) {
			this.dealerId = dealerId;
		}

		public String getDealerName() {
			return dealerName;
		}

		public void setDealerName(String dealerName) {
			this.dealerName = dealerName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
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
