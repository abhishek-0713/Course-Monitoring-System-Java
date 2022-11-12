package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learninghub.exceptions.AdminException;
import com.learninghub.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

//	
//	///// ****************         Administrator Registration          ************* /////
//
//	@Override
//	public String registerAdmin(Admin admin) throws AdminException {
//		
//		String result = "Not Registered..";
//		
//		try(Connection conn= DBUtil.provideConnection()) {
//			
//			PreparedStatement ps= conn.prepareStatement("INSERT INTO Admin VALUES(?,?)");
//			
//			ps.setString(1, Admin.);
//			ps.setString(2, student.getAddress());
//			ps.setString(3, student.getEmail());
//			ps.setString(4, student.getPassword());
//			
//			
//			int x= ps.executeUpdate();
//			
//			if(x >0)
//				result = "Student Registered Sucessfully..";
//				
//			
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new StudentException(e.getMessage());
//		}
//		
//		
//
//		return result;
//	}
//

	
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
