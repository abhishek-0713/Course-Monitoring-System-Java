package com.learninghub.main.course;

import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Course;

public class CreateCourse {

	public static void addCourceMtd() throws InputException{

		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Course Name       : "+Style.RESET);
			String cname = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Course Fee        : "+Style.RESET);
			int cfee = sc.nextInt();
			
			sc.nextLine();
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Couse Description : "+Style.RESET);
			String cdesc = sc.nextLine();
			
			Course course = new Course(cname, cfee, cdesc);
			
			CourseDao dao = new CourseDaoImpl();
			
			String res;
			try {
				res = dao.addCourse(course);
				System.out.println("\n" + res + "\n");
				
			} catch (CourseException e) {
				System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
			}
			
		}catch(Exception e) {
			throw new InputException(Style.RED_UNDERLINED+"               Invalid Input               "+Style.RESET);						
		}
		
		
	}

}
