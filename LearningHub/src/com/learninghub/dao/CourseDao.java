package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.CourseException;
import com.learninghub.model.Course;

public interface CourseDao {

	public String createCourse(Course course) throws CourseException;
	
	public String updateCourse(String updateFeild, String update, String courseName) throws CourseException;
	
	public Course searchCourse(String courseName) throws CourseException;
	
	public List<Course> allCourseList() throws CourseException;
	
	public String deleteBatch(String courseName) throws CourseException;
	
}
