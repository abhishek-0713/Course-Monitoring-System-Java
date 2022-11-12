package com.learninghub.main.course;

import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class DeleteCourse {
	
public static void deleteCourse() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(Style.CYAN+"Enter Name of Course"+Style.RESET);
			String cName = sc.next();
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				String res = dao.deleteBatch(cName);
				System.out.println();
				System.out.println(res);
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
