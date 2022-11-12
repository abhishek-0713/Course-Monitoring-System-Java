package com.learninghub.main.course;

import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Course;

public class SearchCourse {

	public static void searchByCourse() throws InputException{
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(Style.CYAN+"Enter Name of Course"+Style.RESET);
			String cname = sc.next();
			
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				Course c = dao.searchCourse(cname);
				System.out.println();
				System.out.println(Style.ORANGE+"Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------"+Style.RESET);
				System.out.println();
				
			} catch (CourseException e) {
				System.out.println();
				System.out.println(Style.RED_BACKGROUND+ e.getMessage()+Style.RESET);
				System.out.println();
			}
		}catch(Exception e) {
			throw new InputException(Style.RED+"Please Enter Right Input"+Style.RESET);
			
		}
		
	}

}
