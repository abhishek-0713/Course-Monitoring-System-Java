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

public class UpdatePassword {

	public static void chnagePass(int facultyId) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.print("Enter Old Password : ");
			String oldPass = sc.next();
			
			System.out.print("Enter New Password: ");
			String newPass = sc.next();
			
			System.out.print("Enter New Password : ");
			String newPass2 = sc.next();
			
			
			PreparedStatement ps = conn .prepareStatement("SELECT * FROM faculty WHERE facultyId = ? And password = ?");
			ps.setInt(1, facultyId);
			ps.setString(2, oldPass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(newPass.equals(newPass2)) {
					
					FacultyDao dao = new FacultyDaoImpl();
					
					try {
						String res = dao.updatePassword(facultyId, newPass2);
						System.out.println(res);
					} 
					catch (FacultyException e) {
						
						System.out.println( e.getMessage());
					}
					
				}else {
					System.out.println("New Password Mismatch..");
				}
				
			}else {
				System.out.println("Wrong Old Password..");				
			}
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		}
		
	}
	
}
