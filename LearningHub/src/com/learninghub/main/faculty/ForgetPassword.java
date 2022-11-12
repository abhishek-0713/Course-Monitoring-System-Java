package com.learninghub.main.faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.utility.DBUtil;

public class ForgetPassword {

	public static boolean forgetPassword() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.print("Enter Mobile No. : ");
			String mobile = sc.next();
			
			System.out.print("Enter Email No. : ");
			String email = sc.next();
			
			
			
			PreparedStatement ps = conn .prepareStatement("SELECT * FROM faculty WHERE mobile = ? and email = ?");
			ps.setString(1, mobile);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				FacultyDao dao = new FacultyDaoImpl();
					
				System.out.print("Enter New Password: ");
				String newPass = sc.next();
				
				
				System.out.print("Enter New Password Again : ");
				String newPass2 = sc.next();
				

				if(newPass.equals(newPass2)) {
					
					
					try {
						String res = dao.forgetPassword(mobile, email, newPass2);
						System.out.println(res);
						
					} catch (FacultyException e) {
						System.out.println(e.getMessage());
						return false;
					}
					
				}else {
					System.out.println("New Password Mismatch..");
					return false;
				}
				
				
			}else {
				System.out.println("Mobile Number or Email Not Found..");
				return false;
				
			}
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			return false;
			
		}
		return true;
		
	}
	
}
