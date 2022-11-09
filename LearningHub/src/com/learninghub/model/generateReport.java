package com.learninghub.model;

public class generateReport {

	private String FName;
	private String batchId;
	private String batchstartDate;
	private int courseId; 
	private String duration;
	private int noOfStudents;
	private int completed;
	
	
	public generateReport() {
		super();
	}


	public String getFName() {
		return FName;
	}


	public void setFName(String fName) {
		FName = fName;
	}


	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public String getBatchstartDate() {
		return batchstartDate;
	}


	public void setBatchstartDate(String batchstartDate) {
		this.batchstartDate = batchstartDate;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public int getNoOfStudents() {
		return noOfStudents;
	}


	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}


	public int getCompleted() {
		return completed;
	}


	public void setCompleted(int completed) {
		this.completed = completed;
	}


	@Override
	public String toString() {
		return "generateReport [FName=" + FName + ", batchId=" + batchId + ", batchstartDate=" + batchstartDate
				+ ", courseId=" + courseId + ", duration=" + duration + ", noOfStudents=" + noOfStudents
				+ ", completed=" + completed + "]";
	}
	
	
	
}
