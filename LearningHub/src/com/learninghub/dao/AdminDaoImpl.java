package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learninghub.exceptions.AdminException;
import com.learninghub.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	
	///// ****************         Administrator Registration          ************* /////

	@Override
	public boolean register(String name, String userName, String password) throws AdminException {
		// TODO Auto-generated method stub
		return false;
	}

	
	///// ****************        Administrator Login          ************* /////

	@Override
	public boolean login(String userName, String password) throws AdminException {
		// TODO Auto-generated method stub
		
		boolean isLoggedIn = false;
		
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM Admin WHERE username = ? ");
			
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM Admin WHERE username = ? AND password = ?");
				
				ps2.setString(1, userName);
				ps2.setString(2, password);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					isLoggedIn = true;
				}
				else {
					throw new AdminException("Please Check Your Password.");
				}
			}
			else {
				throw new AdminException("Please Enter Valid Admin Details.");
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}

		
		return isLoggedIn;
	}
	
	

}
