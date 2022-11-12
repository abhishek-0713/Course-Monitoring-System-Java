package com.learninghub.main.course;

import java.util.List;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.model.Course;

public class AllCourse {


	public static void viewAllCourse() {
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> courses = dao.allCourseList();
			
			courses.forEach( c -> {
				
				System.out.println();
				System.out.println("Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDescription());

			});
			System.out.println();
			
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
