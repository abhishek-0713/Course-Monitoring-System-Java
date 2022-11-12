package com.learninghub.main.courseplan;

import java.util.Scanner;

public class ViewChoice {

public static void viewOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. View All Plan Day Wise");
				System.out.println("2. Search By Faculty");
				System.out.println("3. Back");
				System.out.println("4. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Date: ");
					String date = sc.next();
					ViewCoursePlanPerDay.viewAllPlan(date);;
					
				}else if(ch == 2) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFaculty.checkFacultyId(facultyId)) {	
						ViewCoursePlan.viewAllPlan();
						
					}else {
						System.out.println("No Faculty Present with FacultyId "+facultyId);
					}
					
				}else if(ch == 3) {
					break;
					
				}else if(ch == 4) {
					System.out.println("See You Soon...");
					System.exit(0);
					
				}else {
					System.out.println("Wrong Input Try Again!");					
				}
				
			}
		}catch (Exception e) {
			System.out.println("Please Enter Right Input");
			viewOptions();
		}
		
	}
	
}
