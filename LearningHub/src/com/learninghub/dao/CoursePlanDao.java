package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.CoursePlanException;
import com.learninghub.model.coursePlan;

public interface CoursePlanDao {

	public String createCoursePlan(int batchId, int dayNumber)throws CoursePlanException;
	
	public List<coursePlan> viewCoursePlan() throws CoursePlanException;
	
	public List<coursePlan> viewCoursePlanperDay(String date) throws CoursePlanException;
	
	public List<coursePlan> viewFacultyCP(int facultyId) throws CoursePlanException;
	
	public String updateStatus(int batchId, int dayNumber)throws CoursePlanException;
	
	public String updateTopic(int batchId, int dayNumber, String topic)throws CoursePlanException;
	
	public String updateDate(int batchId, int dayNumber, int updatedDate) throws CoursePlanException;
		
	
}
