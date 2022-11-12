package com.learninghub.main.course;

import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.exceptions.InputException;
import com.learninghub.model.Course;

public class CreateCourse {

	public static void createCourse() throws InputException {	

		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Name of the Course : ");
			String cname = sc.next();
			
			System.out.print("Enter the Course Fee");
			int cfee = sc.nextInt();
			
			sc.nextLine();
			System.out.println(" Enter Couse Description : ");
			String cdesc = sc.nextLine();
			
			Course course = new Course(cname, cfee, cdesc);
			
			CourseDao dao = new CourseDaoImpl();
			
			String res;
			try {
				res = dao.createCourse(course);

				System.out.println(res);
				
			} catch (CourseException e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input");
			
		}
		
	}
}
