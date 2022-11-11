package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.FacultyException;
import com.learninghub.model.Faculty;

public interface FacultyDao {

	public Faculty login(String username, String password) throws FacultyException;
	
	public String createFaculty(Faculty faculty) throws FacultyException;
	
	public List<Faculty> allFaculty() throws FacultyException;

	public String updateFaculty(String updatedFeild, String update, int facultyId) throws FacultyException;
	
	public String forgetPassword(String mobile, String email, String Password)throws FacultyException;
	
	public String updatePassword(int facultyId, String password) throws FacultyException;
	

}
