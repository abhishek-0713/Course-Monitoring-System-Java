package com.learninghub.main.courseplan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learninghub.utility.DBUtil;

public class CheckFaculty {


	public static boolean checkFacultyId(int facultyId) {
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where facultyId = ?");
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			
		}
		
		return false;
	}
	
}
