package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.learninghub.exceptions.BatchException;
import com.learninghub.model.Batch;
import com.learninghub.model.generateReport;
import com.learninghub.utility.DBUtil;

public class BatchDaoImpl implements BatchDao {
	
	///// ****************        CREATE BATCH          ************* /////
	@Override
	public String createBatch(Batch batch) throws BatchException {
		
		String result = "No Batch Record Inserted.";
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps =  conn.prepareStatement("SELECT courseName FROM Course WHERE courseId = ?");
			
			ps.setInt(1, batch.getCourseId());
			
			ResultSet rs = ps.executeQuery();
			
			String courseName = "";
			
			if(rs.next()) {
				courseName = rs.getString("courseName");
			}
			
			
			PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(courseId) FROM Batch WHERE courseId = ?");
			
			ps2.setInt(1, batch.getCourseId());
			
			ResultSet rs2 = ps2.executeQuery();
			
			int id = 0;
			
			if(rs2.next()) {
				id = rs2.getInt(1);
			}
			id++;
			
			String convert = String.format("%03d", id);
			String batchId = courseName + convert;
			
			
			PreparedStatement ps3 = conn.prepareStatement("INSERT INTO Batch VALUES(?,?,?,?,?,?)");

			ps3.setString(1, batchId);
			ps3.setInt(2, batch.getCourseId());
			ps3.setInt(3, batch.getFacultyId());
			ps3.setInt(4, batch.getNumberOfStudents());
			ps3.setString(5, batch.getBatchStartDate());
			ps3.setString(6, batch.getDuration());
			
			int x = ps3.executeUpdate();
			
			if(x > 0) {
				result = "New Batch Created Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return result;
		
	}

	
	///// ****************        UPDATE BATCH          ************* /////
	@Override
	public String updateBatch (String str, String set, String batchId) throws BatchException {
		
		String result = "Batch Data Need To Be Updated.";
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE Batch SET ");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return batchId;
		
	}

	
	///// ****************        SEARCH BATCH          ************* /////
	@Override
	public Batch searchBatchById(String id) throws BatchException {
		return null;
		
	}

	
	///// ****************        VIEW BATCH          ************* /////
	@Override
	public List<Batch> viewallBatch() throws BatchException {
		return null;
		
	}

	
	///// ****************        ALLOCATE FACULTY TO A BATCH          ************* /////
	@Override
	public String allocateFaculty(int fName, String batchId) throws BatchException {
		return batchId;
		
	}
	
	
	///// ****************        GEANERATE REPORT FOR EVERY BATCH          ************* /////
	@Override
	public List<generateReport> generateReportFromBatch() throws BatchException {
		return null;
		
	}
	
	
	///// ****************        DELETE BATCH          ************* /////
	@Override
	public String deleteBatch(String batchId) throws BatchException {
		return batchId;
		
	}


}
