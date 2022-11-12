package com.learninghub.dao;

import com.learninghub.exceptions.AdminException;

public interface AdminDao {


	public boolean login(String userName, String password) throws AdminException;

//	public String registerAdmin(Admin admin) throws AdminException; 

}
