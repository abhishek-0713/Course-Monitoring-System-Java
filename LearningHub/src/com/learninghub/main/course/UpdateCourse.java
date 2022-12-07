package com.learninghub.main.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.extrafeatures.Style;

public class UpdateCourse {

	public static void updateCourse(String name){
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			boolean flag2 = true;
			
			while(flag) {
				
				String str = "";
				
				while(true) {
					
					System.out.println(Style.BLUE_BOLD_BRIGHT+"Update : ");

					System.out.println(Style.TEAL+"+--------------------------------------------------+");
					System.out.println("|   1    |      Course Name                        |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   2    |      Course Fee                         |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   3    |      Course Description                 |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   4    |      Back To Main                       |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   5    |      Exit                               |");
					System.out.println("+--------------------------------------------------+\n" + Style.RESET);
					
					System.out.print(Style.GREEN+"Enter Your Choise : ");	
					int ch = sc.nextInt();
					
					if(ch == 4) {
						flag = false;
						flag2 = false;
						break;
						
					}else if(ch== 5) {
						System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
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
						System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n" + Style.RESET);	
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
						result = dao.updateCourseDetails(str, set, name);
						System.out.println("\n"+ result + "\n");
						
					} catch (CourseException e) {
						System.out.println("\n            "+ Style.RED_BACKGROUND+ e.getMessage()+ "                 \n" + Style.RESET);
					}
				}
				
				
				while(flag2) {
					System.out.print(Style.GREEN_BOLD_BRIGHT+"Update Again (y/n) : "+Style.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						flag = false;
						break;
					}else {
						System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	
					}
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("\n               Invalid Input Try Again!               \n" + Style.RESET);	
			updateCourse(name);
		}

	}

}
