package com.learninghub.main.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class CourseChoice {
	
	public static void courseOptions() {
		
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println(Style.TEAL+"+--------------------------------------------------+");
				System.out.println("|   1    |      Add Course                         |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   2    |      Update Course                      |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   3    |      Search Course                      |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   4    |      Delete Course                      |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   5    |      Back To Main Menu                  |");
				System.out.println("+--------------------------------------------------+");
				System.out.println("|   6    |      Exit                               |");
				System.out.println("+--------------------------------------------------+\n"+Style.RESET);

				System.out.print(Style.GREEN+"Enter Your Choise : ");	
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						CreateCourse.addCourceMtd();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						
					}
					
				}else if(ch == 2) {
					
					while(true) {
						System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter name of Course  : "+Style.RESET);
						String name = sc.next();
						
						boolean flag = SearchCourseByName.searchByName(name);
						if(flag) {					
							UpdateCourse.updateCourse(name);
							break;
						}else {
							System.out.println(Style.RED_UNDERLINED+"\nCourse Does Not Exist!\n"+Style.RESET);
						}
					}
					
				}else if(ch == 3) {
					CourseSearchChoice.courseSearchOptions();
					
				}else if(ch == 4) {
					try {
						DeleteCourse.deleteCourse();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 5) {
					break;
					
				}else if(ch == 6) {
					System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
					System.exit(0);
					
				}else {
					System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	
				}
				
			}
			System.out.println();
		}catch(InputMismatchException ie) {
			System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);
			courseOptions();
			
		}
		
	}
	
}
