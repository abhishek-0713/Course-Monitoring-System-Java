package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learninghub.exceptions.CourseException;
import com.learninghub.model.Course;
import com.learninghub.utility.DBUtil;

public class CourseDaoImpl implements CourseDao {

	///// ****************        CREATE COURSE          ************* /////

	@Override
	public String createCourse(Course course) throws CourseException {
		// TODO Auto-generated method stub

		String result = "No COURSE Record Inserted.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT courseName FROM Course WHERE courseId = ?");
			
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCourseFee());
			ps.setString(3, course.getCourseDescription());		
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "New Course Created Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
		
	}

	
	///// ****************        UPDATE COURSE          ************* /////

	@Override
	public String updateCourse(String updateFeild, String update, String courseName) throws CourseException {
		// TODO Auto-generated method stub

		String result = "COURSE Data Need to be Updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("UPDATE Course SET "+ updateFeild + " = ? WHERE courseName = ?");
			
			ps.setString(1, updateFeild);
			ps.setString(2, courseName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "New Course Created Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
	}

	
	///// ****************        SEARCH COURSE          ************* /////

	@Override
	public Course searchCourse(String courseName) throws CourseException {
		// TODO Auto-generated method stub

		Course course = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM Course WHERE courseName = ?");
			
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int courseId = rs.getInt("courseId");
				String coursename = rs.getString("courseName");
				int courseFee = rs.getInt("courseFee");
				String courseDescription = rs.getString("courseDescription");
				
				course = new Course(courseId, coursename, courseFee, courseDescription);
			}
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
		
	}

	
	///// ****************        COURSE LIST           ************* /////

	@Override
	public List<Course> allCourseList() throws CourseException {
		// TODO Auto-generated method stub

		List<Course> courseList = new ArrayList<>();
		

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM Course");
			
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()) {
				
				int courseId = rs.getInt("courseId");
				String coursename = rs.getString("courseName");
				int courseFee = rs.getInt("courseFee");
				String courseDescription = rs.getString("courseDescription");
				
				Course course = new Course(courseId, coursename, courseFee, courseDescription);
				
				courseList.add(course);
			}
	
			
			if(courseList.size() == 0) {
				throw new CourseException("No Courses Created Yet.");
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return courseList;

		
	}

	
	///// ****************        DELETE COURSE          ************* /////

	@Override
	public String deleteBatch(String courseName) throws CourseException {
		// TODO Auto-generated method stub

		String result = "COURSE Data Need to be Updated.";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("DELETE FROM Course WHERE courseName = ?");
			
			ps.setString(1, courseName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Course deleted Successfully.";
			}
			
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
	}
}
