package com.learninghub.main.facultyrights;

import java.util.Scanner;

import com.learninghub.extrafeatures.Style;
import com.learninghub.main.faculty.UpdateFaculty;
import com.learninghub.model.Faculty;

public class FacultySettings {
	
public static void facultySettings(Faculty faculty) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|   1    |      Update profile Details             |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   2    |      Update Password                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   3    |      Back to Previous Menu             |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   4    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			System.out.print(Style.GREEN+"Enter Your Choise : ");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateFaculty.UpdateById(faculty.getFacultyId());
					
			}else if(ch == 2) {
				UpdatePassword.chnagePass(faculty.getFacultyId());

			}else if(ch== 4) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}
			else {
				System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);	
				facultySettings(faculty);
			}
			
		}
		
	}
	
}
