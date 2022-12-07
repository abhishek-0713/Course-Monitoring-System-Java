package com.learninghub.main.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class CourseSearchChoice {
	
	public static void courseSearchOptions() {
		
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
				
			while(true) {
				System.out.println(Style.TEAL+"+--------------------------------------------------+");
				System.out.println("|   1    |      Search Course By Name              |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   2    |      View All Courses                   |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   3    |      Back To Main Menu                  |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   4    |      Exit                               |");
				System.out.println("+--------------------------------------------------+\n"+Style.RESET);

				System.out.print(Style.GREEN+"Enter Your Choise : ");	
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						SearchCourse.searchByCourse();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 2) {
					ViewAllCourse.viewAllCourse();
					
				}else if(ch == 3) {
					break;
					
				}else if(ch == 4) {
					System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
					System.exit(0);
					
				}else {
					System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);		
				}
			}
			
		}catch(InputMismatchException ie) {
			System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);
			courseSearchOptions();
			
		}
		
	}
}
