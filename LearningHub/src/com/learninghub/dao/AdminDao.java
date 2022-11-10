package com.learninghub.dao;

import com.learninghub.exceptions.AdminException;

public interface AdminDao {

	public boolean register( String name, String userName, String password) throws AdminException; 

	public boolean login(String userName, String password) throws AdminException; 

}
