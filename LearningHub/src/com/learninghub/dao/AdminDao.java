package com.learninghub.dao;

import com.learninghub.exceptions.AdminException;

public interface AdminDao {

	public boolean login(String userName, String password) throws AdminException; 

}
