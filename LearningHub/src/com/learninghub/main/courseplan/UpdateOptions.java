package com.learninghub.main.courseplan;

import java.util.Scanner;

public class UpdateOptions {

	public static void CourseOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Update Status");
				System.out.println("2. Update Date");
				System.out.println("3. Back");
				System.out.println("4. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFaculty.checkFacultyId(facultyId)) {
						UpdateStatus.updateStatus(facultyId);
					}else {
						System.out.println("No Faculty Present with FacultyId "+facultyId);
					}
					
				}else if(ch == 2) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFaculty.checkFacultyId(facultyId)) {
						UpdateDate.updateDate(facultyId);
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
			CourseOptions();
		}
		
	}
	
}
