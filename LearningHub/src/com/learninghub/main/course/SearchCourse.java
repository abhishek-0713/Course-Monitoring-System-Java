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
			
			System.out.print(Style.BLUE_BOLD_BRIGHT + "Enter Course Name : "+Style.RESET);
			String cname = sc.next();
			
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				Course c = dao.searchCourse(cname);
				System.out.println(Style.CYAN_BOLD_BRIGHT+"\n+--------------------------------------------------+");
				System.out.println("|  Course Id          :    "+ c.getCourseId());
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Name        :    " + c.getCourseName());
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Fee         :    " + c.getCourseFee() + " Rs.");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|  Course Description :    " + c.getCourseDesc());
				System.out.println("+--------------------------------------------------+\n"+Style.RESET);

				
			} catch (CourseException e) {
				System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);		
			}
		}catch(Exception e) {
			throw new InputException(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n"+Style.RESET);

		}
		
	}

}
