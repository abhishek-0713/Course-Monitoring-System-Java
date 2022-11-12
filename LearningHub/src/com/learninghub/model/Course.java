package com.learninghub.model;

public class Course {

	private int courseId;
	private String courseName;
	private int courseFee;
	private String courseDescription;
	

	public Course() {
		super();
	}


	public Course(int courseId, String courseName, int courseFee, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDescription = courseDescription;
	}


	public Course(String courseName, int courseFee, String courseDescription) {
		// TODO Auto-generated constructor stub
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDescription = courseDescription;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCourseFee() {
		return courseFee;
	}


	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}


	public String getCourseDescription() {
		return courseDescription;
	}


	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseDescription=" + courseDescription + "]";
	}
	
	

}

