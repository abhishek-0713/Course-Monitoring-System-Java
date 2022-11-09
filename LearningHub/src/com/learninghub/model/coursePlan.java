package com.learninghub.model;

public class coursePlan {

	private int planId;
	private int batchId;
	private int dayNumber;
	private String cptopic;
	private String cpDate;
	private boolean status;
	
	
	public coursePlan() {
		super();
	}


	public coursePlan(int planId, int batchId, int dayNumber, String cptopic, String cpDate, boolean status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.dayNumber = dayNumber;
		this.cptopic = cptopic;
		this.cpDate = cpDate;
		this.status = status;
	}


	public int getPlanId() {
		return planId;
	}


	public void setPlanId(int planId) {
		this.planId = planId;
	}


	public int getBatchId() {
		return batchId;
	}


	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}


	public int getDayNumber() {
		return dayNumber;
	}


	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}


	public String getCptopic() {
		return cptopic;
	}


	public void setCptopic(String cptopic) {
		this.cptopic = cptopic;
	}


	public String getCpDate() {
		return cpDate;
	}


	public void setCpDate(String cpDate) {
		this.cpDate = cpDate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "coursePlan [planId=" + planId + ", batchId=" + batchId + ", dayNumber=" + dayNumber + ", cptopic="
				+ cptopic + ", cpDate=" + cpDate + ", status=" + status + "]";
	}
	
	
	
}
