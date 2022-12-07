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
				
				System.out.println(Style.CYAN_BOLD_BRIGHT+"\n+--------------------------------------------------+");
				System.out.println("|  Course Id          :    "+ c.getCourseId());
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Name        :    " + c.getCourseName());
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Fee         :    " + c.getCourseFee() + " Rs.");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Description :    " + c.getCourseDesc());
				System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			});
			System.out.println(Style.GREEN_UNDERLINED + "***************************************************************\n"+ Style.RESET);
			
		} catch (CourseException e) {
			System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
		}
		
	}
	
}
