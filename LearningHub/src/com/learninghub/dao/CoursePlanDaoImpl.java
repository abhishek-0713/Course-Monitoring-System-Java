package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.learninghub.exceptions.CoursePlanException;
import com.learninghub.model.coursePlan;
import com.learninghub.utility.DBUtil;

public class CoursePlanDaoImpl implements CoursePlanDao {

	///// ****************        CREATE COURSE PLAN         ************* /////

	@Override
	public String createCoursePlan(int batchId, int dayNumber) throws CoursePlanException {
		// TODO Auto-generated method stub

		String result = "No CoursePlan Record Inserted.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT batchStartDate FROM Batch WHERE batchId = ?");
			
			ps.setInt(1, batchId);
			
			ResultSet rs = ps.executeQuery();
			
			String update = "";
			
			if(rs.next()) {
				Date date = rs.getDate("batchStartDate");
				update =  date.toString();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				
				try {
					c.setTime(df.parse(update));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				c.add(Calendar.DATE, dayNumber-1);
				
				update = df.format(c.getTime());
			}
			

			PreparedStatement ps2 =  conn.prepareStatement("INSERT INTO CoursePlan(batchId, dayNumber, date) VALUES(?,?,?)");
			
			ps2.setInt(1, batchId);
			ps2.setInt(2, dayNumber);
			ps2.setString(3, update);
			
			
			int x = ps2.executeUpdate();
			
			if(x > 0) {
				result = "New CoursePlan Created Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return result;
		

	}

	
	///// ****************        VIEW COURSE PLAN        ************* /////

	@Override
	public List<coursePlan> viewCoursePlan() throws CoursePlanException {
		// TODO Auto-generated method stub

		List<coursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM coursePlan ORDER BY date ASC");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int planId = rs.getInt("planId");
				int batchId = rs.getInt("batchId");
				int dayNumber = rs.getInt("dayNumber");
				String topic = rs.getString("topic");
				Date date = rs.getDate("date");
				boolean status = rs.getBoolean("status");
				
				String ud = date.toString();

				coursePlan cp = new coursePlan(planId, batchId, dayNumber, topic, ud, status);
				
				coursePlanList.add(cp);
			}
	
			
			if(coursePlanList.size() == 0) {
				throw new CoursePlanException("No CoursesPlan Created Yet.");
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return coursePlanList;
		
	}

	
	///// ****************        VIEW COURSE DAY PLAN         ************* /////

	@Override
	public List<coursePlan> viewCoursePlanperDay(String date) throws CoursePlanException {
		// TODO Auto-generated method stub

		List<coursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM coursePlan WHERE date = ? ORDER BY date ASC");
			
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int planId = rs.getInt("planId");
				int batchId = rs.getInt("batchId");
				int dayNumber = rs.getInt("dayNumber");
				String topic = rs.getString("topic");
				Date pdate = rs.getDate("date");
				boolean status = rs.getBoolean("status");
				
				String ud = pdate.toString();

				coursePlan cp = new coursePlan(planId, batchId, dayNumber, topic, ud, status);
				
				coursePlanList.add(cp);
			}
	
			
			if(coursePlanList.size() == 0) {
				throw new CoursePlanException("No CoursesPlan Created Yet.");
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return coursePlanList;
		
	}

	
	///// ****************        VIEW FACULTY COURSE PLAN         ************* /////

	@Override
	public List<coursePlan> viewFacultyCP(int facultyId) throws CoursePlanException {
		// TODO Auto-generated method stub

		List<coursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT A.* FROM coursePlan A, Batch B WHERE A.batchId = B.batchId AND B.facultyId = ? ORDER BY date ASC");
			
			ps.setInt(1, facultyId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int planId = rs.getInt("planId");
				int batchId = rs.getInt("batchId");
				int dayNumber = rs.getInt("dayNumber");
				String topic = rs.getString("topic");
				Date date = rs.getDate("date");
				String ud = date.toString();
				boolean status = rs.getBoolean("status");
				
				coursePlan cp = new coursePlan(planId, batchId, dayNumber, topic, ud, status);
				
				coursePlanList.add(cp);
			}
	
			
			if(coursePlanList.size() == 0) {
				throw new CoursePlanException("No CoursesPlan Created Yet.");
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return coursePlanList;
		
	}

	
	///// ****************        UPDATE COURSE PLAN STATUS         ************* /////

	@Override
	public String updateStatus(int batchId, int dayNumber) throws CoursePlanException {
		// TODO Auto-generated method stub

		String result = "CoursePlan Status Need to be Updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT DATEDIFF(date, curdate()) as date FROM coursePlan WHERE batchId = ? AND dayNumber = ?");
			
			ps.setInt(1, batchId);
			ps.setInt(2, dayNumber);
			
			ResultSet rs = ps.executeQuery();
			
			int difference = -1;
			
			if(rs.next()) {
				difference = rs.getInt(1);
			}
			if(difference <= 0) {
		
			PreparedStatement ps2 =  conn.prepareStatement("INSERT INTO CoursePlan(batchId, dayNumber, date) VALUES(?,?,?)");
			
			ps2.setInt(1, batchId);
			ps2.setInt(2, dayNumber);
		
			
			int x = ps2.executeUpdate();
			
			if(x > 0) {
				result = "New CoursePlan Created Successfully.";
			}
			}
			else {
				throw new CoursePlanException("You can not change Date");
			}
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return result;
		
	}

	
	///// ****************        UPDATE COURSE TOPIC       ************* /////

	@Override
	public String updateTopic(int batchId, int dayNumber, String topic) throws CoursePlanException {
		// TODO Auto-generated method stub

		String result = "CoursePlan Topic Need to be Updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("UPDATE coursePlan SET Topic = ? WHERE batchId = ? AND dayNumber = ?");
			
			ps.setString(1, topic);
			ps.setInt(2, batchId);
			ps.setInt(3, dayNumber);
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "CoursePlan Topic Updated Successfully.";
			}
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return result;
	}

	
	///// ****************        UPDATE COURSE PLAN DATE         ************* /////

	@Override
	public String updateDate(int batchId, int dayNumber, int updatedDate) throws CoursePlanException {
		// TODO Auto-generated method stub

		String result = " CoursePlan Date need to be updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT batchStartDate FROM Batch WHERE batchId = ?");
			
			ps.setInt(1, batchId);
			
			ResultSet rs = ps.executeQuery();
			
			String update = "";
			
			if(rs.next()) {
				Date date = rs.getDate("batchStartDate");
				update =  date.toString();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				
				try {
					c.setTime(df.parse(update));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				c.add(Calendar.DATE, dayNumber-1);
				
				update = df.format(c.getTime());
			}
			

			PreparedStatement ps2 =  conn.prepareStatement("UPDATE coursePlan SET dayNumber = ? WHERE batchId = ? AND dayNumber = ?");
			
			ps2.setInt(1, updatedDate);
			ps2.setInt(2, batchId);
			ps2.setInt(3, dayNumber);
			
			
			int x = ps2.executeUpdate();
			
			if(x > 0) {
				
				PreparedStatement ps3 =  conn.prepareStatement("UPDATE coursePlan SET date = ? WHERE batchId = ? AND dayNumber = ?");
				
				ps3.setString(1, update);
				ps3.setInt(2, batchId);
				ps3.setInt(3, updatedDate);
				
				
				int y = ps3.executeUpdate();
				
				if(y > 0) {
					result = "CoursePlan date updated Successfully.";
				}
				
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return result;
	}

}
