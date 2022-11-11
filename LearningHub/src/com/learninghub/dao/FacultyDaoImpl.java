package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learninghub.exceptions.FacultyException;
import com.learninghub.model.Faculty;
import com.learninghub.properties.AutoPassGen;
import com.learninghub.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	///// ****************        LOGIN FACULTY          ************* /////

	@Override
	public Faculty login(String username, String password) throws FacultyException {
		// TODO Auto-generated method stub
		Faculty faculty = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM Faculty WHERE username = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 =  conn.prepareStatement("SELECT * FROM Faculty WHERE username = ? AND password = ?");

				ps2.setString(1, username);
				ps2.setString(2, password);
				
				ResultSet rs2 = ps2.executeQuery();
				
				
				if(rs2.next()) {
					
					int facultyId = rs.getInt("facultyId");
					String facultyName = rs.getString("facultyName");
					String facultyAddress = rs.getString("facultyAddress");
					String mobile = rs.getString("mobile");
					String email = rs.getString("email");
					String userName = rs.getString("username");

					faculty = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, userName);
				}
			}		
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return faculty;
	}
	
	
	///// ****************        CREATE FACULTY          ************* /////

	@Override
	public String createFaculty(Faculty faculty) throws FacultyException {
		// TODO Auto-generated method stub

		String result = "No Faculty Record Inserted.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			Statement st =  conn.createStatement();
			
			String mysql = "SELECT MAX(facultyId) FROM Faculty";
			
			ResultSet rs = st.executeQuery(mysql);
			
			Integer fId = 0;
			
			if(rs.next()) {
				fId = rs.getInt("MAX(facultyId)");
			}
			fId = fId + 1;
			
			String update = String.format("%03d", fId);
			String facultyName = faculty.getFacultyName().toLowerCase();
			String username = facultyName + update;
			String password = AutoPassGen.generatepass(8);
			

			PreparedStatement ps2 =  conn.prepareStatement("INSERT INTO Faculty(facultyName, facultyAddress, mobile, email, username, password) VALUES(?,?,?,?,?,?)");
			
			ps2.setString(1, faculty.getFacultyName());
			ps2.setString(2, faculty.getFacultyAddress());
			ps2.setString(3, faculty.getMobile());
			ps2.setString(4, faculty.getEmail());
			ps2.setString(5, username);
			ps2.setString(6, password);
			
			int x = ps2.executeUpdate();
			
			if(x > 0) {
				result = "New Faculty Created Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return result;
	}

	
	///// ****************        ALL FACULTY          ************* /////

	@Override
	public List<Faculty> allFaculty() throws FacultyException {
		// TODO Auto-generated method stub


		List<Faculty> facultyList = new ArrayList<>();
		

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("INSERT * FROM Faculty");
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int fId = rs.getInt("facultyId");
				String facultyName = rs.getString("facultyName");
				String facultyAddress = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				Faculty faculty = new Faculty(fId,facultyName, facultyAddress, mobile, email, username);		
	
				facultyList.add(faculty);
					
			}
			
			if(facultyList.size() == 0) {
				
				throw new FacultyException("No Record Found.");

			}			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}

		
		return facultyList;
	}

	
	///// ****************        UPDATE FACULTY          ************* /////

	@Override
	public String updateFaculty(String updatedFeild, String update, int facultyId) throws FacultyException {
		// TODO Auto-generated method stub

		String result = " Faculty Record Not Updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps =  conn.prepareStatement("UPDATE Faculty SET" + updatedFeild + " = ? WHERE facultyId = ?");
			
			ps.setString(1, updatedFeild);
			ps.setInt(2, facultyId);
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = " Faculty updated Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return result;
	}


	
	///// ****************        RESET PASSWORD          ************* /////


	@Override
	public String forgetPassword(String mobile, String email, String password) throws FacultyException {
		// TODO Auto-generated method stub

		String result = "Unable to change your Password.";
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps =  conn.prepareStatement("UPDATE Faculty SET password = ? WHERE mobile = ? AND email = ?");
			
			ps.setString(1, password);
			ps.setString(2, mobile);
			ps.setString(3, email);
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = " Password updated Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return result;
	}
	
	
	///// ****************        UPDATE PASSWORD          ************* /////


	@Override
	public String updatePassword(int facultyId, String password) throws FacultyException {
		// TODO Auto-generated method stub

		String result = "Update Password";
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps =  conn.prepareStatement("UPDATE Faculty SET password = ? WHERE facultyId = ?");
			
			ps.setString(1, password);
			ps.setInt(2, facultyId);
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = " Password updated Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return result;
	}

}
