package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.CourseException;
import com.learninghub.model.Course;

public interface CourseDao {
	
	public String addCourse(Course course)throws CourseException;
	
	public Course searchCourse(String name) throws CourseException;
	
	public List<Course> getAllCourse() throws CourseException;
	
	public String updateCourseDetails(String str, String set, String name) throws CourseException;
	
	public String deleteBatch(String cName) throws CourseException;
}
