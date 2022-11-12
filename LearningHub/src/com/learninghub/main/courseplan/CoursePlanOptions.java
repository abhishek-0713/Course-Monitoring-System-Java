package com.learninghub.main.courseplan;

import java.util.Scanner;

public class CoursePlanOptions {

	public static void CourseOptions() {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add Course Plan");
				System.out.println("2. Update Course Plan");
				System.out.println("3. View Course Plan");
				System.out.println("4. Back");
				System.out.println("5. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFaculty.checkFacultyId(facultyId)) {					
						CreateCoursePlan.addCoursePlan(facultyId);
						
					}else {
						System.out.println("No Faculty Present with FacultyId "+facultyId);
					}		
					
				}
				else if(ch == 2) {
					UpdateOptions.CourseOptions();
					
				}
				else if(ch == 3) {
					ViewChoice.viewOptions();
					
				}
				else if(ch == 5) {
					break;
					
				}else if(ch == 6) {
					System.out.println("See You Soon...");
					System.exit(0);
					
				}else {
					System.out.println("Wrong Input Try Again!");					
				}
				
			}
		}catch (Exception e) {
			System.out.println("Please Enter Right Input");
			CourseOptions();
			
		}
		
	}
	
	
}
