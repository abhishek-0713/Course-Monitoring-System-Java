package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public String updateBatch (String updateField, String update, int batchId) throws BatchException {
		
		String result = "Batch Data Need To Be Updated.";
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE Batch SET " + updateField + " = ? WHERE BatchId = ?");
			
			ps.setString(1, update);
			ps.setInt(2, batchId);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Batch Changes Updated.";
			}
			else {
				throw new BatchException("Batch Suggested For Changes Does Not Exists.");
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());

		}
		
		return result;
		
	}

	
	///// ****************        SEARCH BATCH          ************* /////
	@Override
	public Batch searchBatchById(int batchId) throws BatchException {
		
		Batch batch = null;
			
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT A.batchId, A.courseId, A.facultyId, A.numberOfStuents, A.batchStartDate, A.duration FROM Batch A, Faculty B WHERE  A.facultyId = B.facultyId AND A.batchId = ?");
			
			ps.setInt(1, batchId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int batchid = rs.getInt("batchId");
				int courseid = rs.getInt("courseId");
				int facultyid = rs.getInt("facultyId");
				int numberofstudents = rs.getInt("numberOfStudents");
				String batchstartdate = rs.getString("batchStartDate");
				String batchduration = rs.getString("duration");
				
				batch = new Batch(batchid, courseid, facultyid, numberofstudents, batchstartdate, batchduration );
		
			}
			else {
				throw new BatchException(batchId + " is Not a Valid BatchId.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());

		}
		return batch;
		
	}

	
	///// ****************        VIEW BATCH          ************* /////
	@Override
	public List<Batch> viewallBatch() throws BatchException {
		
		List<Batch> allBatch = new ArrayList<>();
		

		try(Connection conn =  DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Batch");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int batchid = rs.getInt("batchId");
				int courseid = rs.getInt("courseId");
				int facultyid = rs.getInt("facultyId");
				int numberofstudents = rs.getInt("numberOfStudents");
				String batchstartdate = rs.getString("batchStartDate");
				String batchduration = rs.getString("duration");
				
				Batch batch = new Batch(batchid, courseid, facultyid, numberofstudents, batchstartdate, batchduration );
		
				allBatch.add(batch);
			}
			
			
			if(allBatch.size() == 0){
				
				throw new BatchException("No Batch Listed In the Course");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());

		}
		return allBatch;
		
	}

	
	///// ****************        ALLOCATE FACULTY TO A BATCH          ************* /////
	@Override
	public String allocateFaculty(int facultyId, int batchId) throws BatchException {
		

		String result = "No Batch Allocated For BatchId : " + batchId;
		
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Batch SET facultyId = ? WHERE BatchId = ?");
			
			
			ps.setInt(1, facultyId);
			ps.setInt(2, batchId);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Faculty Allocated to the Batch.";
			}
			else {
				throw new BatchException("Batch Suggested For Changes Does Not Exists.");
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());

		}
		
		return result;

		
	}
	
	
	///// ****************        GEANERATE REPORT FOR EVERY BATCH          ************* /////
	@Override
	public List<generateReport> generateReportFromBatch() throws BatchException {
		
		List<generateReport> report = new ArrayList<>();
		

		try(Connection conn =  DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT A.batchId, A.courseId, A.numberOfStudents, A.batchStartDate, A.duration, B.facultyName, COUNT(C.status WHERE status IS TRUE) as Completed FROM Batch A, Faculty B, coursePlan C WHERE A.facultyId = B.facultyId and A.batchId = C.batchId Group By C.batchId Order By ASC");
		
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int batchid = rs.getInt("batchId");
				int courseid = rs.getInt("courseId");
				String facultyname = rs.getString("facultyName");
				int numberofstudents = rs.getInt("numberOfStudents");
				String batchstartdate = rs.getString("batchStartDate");
				String batchduration = rs.getString("duration");
				int completed = rs.getInt("numberOfStudents");
				
				generateReport gr = new generateReport(batchid,batchstartdate,courseid,batchduration,numberofstudents,facultyname,completed);
		
				report.add(gr);
			}
			
			
			if(report.size() == 0){
				
				throw new BatchException("No Batch Listed In the Course");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());

		}
		return report;

		
	}
	
	
	///// ****************        DELETE BATCH          ************* /////
	@Override
	public String deleteBatch(int batchId) throws BatchException {

		String result = "Select Batch to DELETE";
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("DELETE FROM Batch WHERE batchId = ?");
			
			ps.setInt(1, batchId);
		
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Batch Deleted Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return result;
		
	}


}
