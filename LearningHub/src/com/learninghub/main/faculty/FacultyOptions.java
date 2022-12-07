package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class FacultyOptions {
	
	public static void facultyOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|   1    |      Add Faculty                        |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   2    |      Update Faculty                     |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   3    |      Search Faculty                     |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   4    |      Delete Faculty                     |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   5    |      Back To Main Menu                  |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   6    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			System.out.print(Style.GREEN+"Enter Your Choise : ");	
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					CreateFaculty.addFacultyMtd();
					
				} catch (InputException e) {
					System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
				}
				
			}else if(ch == 2) {
				UpdateOptions.updateOptions();
				
			}else if(ch == 3) {
				SearchOptions.searchOptions();
				
			}else if(ch == 4) {
				try {
					DeleteFaculty.deleteFaculty();
				} catch (InputException e) {
					System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
				}
				
			}else if(ch== 6) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}
			else {
				System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");		
			}
		}
		
	}
	
}
