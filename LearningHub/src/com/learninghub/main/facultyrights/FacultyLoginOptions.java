package com.learninghub.main.facultyrights;

import java.util.Scanner;

import com.learninghub.extrafeatures.Style;
import com.learninghub.main.courseplan.UpdateStatus;
import com.learninghub.main.courseplan.UpdateTopic;
import com.learninghub.main.courseplan.ViewFacultyCoursePlan;
import com.learninghub.model.Faculty;

public class FacultyLoginOptions {
	
	public static void facultyOption(Faculty faculty) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|   1    |      Day Planner -Fill Details          |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   2    |      Update Status                      |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   3    |      View Course Plan                   |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   4    |      Update Settings                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   5    |      Log Out                            |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   6    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			System.out.print(Style.GREEN+"Enter Your Choise : ");	
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateTopic.updateTopic(faculty.getFacultyId());
					
			}else if(ch == 2) {
				UpdateStatus.updateStatus(faculty.getFacultyId());

			}else if(ch == 3) {
				ViewFacultyCoursePlan.viewByFaculty(faculty.getFacultyId());
	
			}else if(ch == 4) {
				FacultySettings.facultySettings(faculty);

			}else if(ch== 6) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}
			else {
				System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);	
				facultyOption(faculty);
			}
			
		}
		
	}
	
}
