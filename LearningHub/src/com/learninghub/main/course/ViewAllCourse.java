package com.learninghub.main.course;

import java.util.List;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Course;

public class ViewAllCourse {
	
	public static void viewAllCourse() {
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> courses = dao.getAllCourse();
			
			courses.forEach( c -> {
				
				System.out.println();
				System.out.println(Style.ORANGE+"Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------"+Style.RESET);
				
			});
			System.out.println();
			
		} catch (CourseException e) {
			System.out.println();
			System.out.println(Style.RED_BACKGROUND+ e.getMessage()+Style.RESET);
			System.out.println();
		}
		
	}
	
}
