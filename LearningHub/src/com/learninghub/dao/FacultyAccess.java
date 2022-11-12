package com.learninghub.dao;

import java.util.Scanner;

import com.learninghub.main.courseplan.UpdateStatus;
import com.learninghub.main.courseplan.UpdateTopic;
import com.learninghub.main.courseplan.ViewFacultyCP;
import com.learninghub.model.Faculty;

public class FacultyAccess {

	public static void Access(Faculty faculty) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Fill Day Planner");
			System.out.println("2. Update Status Day Planner");
			System.out.println("3. View Course Plan");
			System.out.println("4. Log Out");
			System.out.println("5. Close the App");
			
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateTopic.updateTopic(faculty.getFacultyId());
					
			}else if(ch == 2) {
				UpdateStatus.updateStatus(faculty.getFacultyId());

			}else if(ch == 3) {
				ViewFacultyCP.viewByFaculty(faculty.getFacultyId());
	
			}else if(ch== 5) {
				System.out.println();
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 4) {
				break;
				
			}
			else {
				System.out.println("Wrong Input Try Again!");
				Access(faculty);
			}
			
		}
	}

	
}
