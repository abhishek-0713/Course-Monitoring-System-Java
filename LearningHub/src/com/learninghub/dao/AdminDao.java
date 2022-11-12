package com.learninghub.dao;

import com.learninghub.exceptions.AdminException;

public interface AdminDao {
	public boolean LoginAdmin(String username , String password) throws AdminException;
	
}
