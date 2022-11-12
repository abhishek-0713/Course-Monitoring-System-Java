package com.learninghub.main.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;

public class UpdateCourse {

	public static void updateCourse(String courseName) {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			boolean flag2 = true;
			
			while(flag) {
				
				String str = "";
				
				while(true) {
					
					System.out.println("What do you want to update?");
					System.out.println("1. Course Name");
					System.out.println("2. Course Fee");
					System.out.println("3. Course Description");
					System.out.println("4. Back");
					System.out.println("5. Close" );
					
					int ch = sc.nextInt();
					
					if(ch == 4) {
						flag = false;
						flag2 = false;
						break;
						
					}else if(ch== 5) {
						System.out.println();
						System.out.println("See You Soon...");
						System.exit(0);	
					}
					
				
					if(ch == 1) {
						str = "courseName";
						break;
					}else if(ch == 2) {
						str = "courseFee";
						break;
					}else if(ch == 3) {
						str = "courseDesc";
						break;
					}else {
						System.out.println();
						System.out.println("Wrong Input Try Again");
						System.out.println();
						flag2 = false;
						break;
					}
				}
				if(flag2) {
					sc.nextLine();
					System.out.println("Enter New Entry :");
					String set = sc.nextLine();
					
					CourseDao dao = new CourseDaoImpl();
					
					String result;
					try {
						result = dao.updateCourse(str, set, courseName);
		
						System.out.println(result);
						
					} catch (CourseException e) {

						System.out.println(e.getMessage());

					}
				}
				
				
				while(flag2) {
					System.out.print("Want to update anything else?(y/n) : ");
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						flag = false;
						break;
					}else {
						System.out.println("Wrong Input...!");
					}
				}
			}
			
		}catch(InputMismatchException e) {

			System.out.println("Wrong Input Try Again!");
			updateCourse(courseName);
		}

		
	}
}
