package com.learninghub.main.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.exceptions.InputException;

public class CourseOptions {

	public static void courseOptions() {
		
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add Course");
				System.out.println("2. Update Course");
				System.out.println("3. Search Course");
				System.out.println("4. Delete Course");
				System.out.println("5. Back");
				System.out.println("6. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						CreateCourse.createCourse();
						
					} catch (InputException e) {
						System.out.println(e.getMessage());
					}
					
				}else if(ch == 2) {
					
					while(true) {
						System.out.println("Enter name of Course");
						String name = sc.next();
						
						boolean flag = SearchCourse.searchByName(name);
						if(flag) {					
							UpdateCourse.updateCourse(name);
							break;
						}else {
							System.out.println("Course Name Doesn't Exist!");
						}
					}
					
				}else if(ch == 3) {
					CourseOptions.courseOptions();
					
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
					System.out.println("See You Soon...");
					System.exit(0);
					
				}else {
					System.out.println("Wrong Input Try Again!");
					
				}
				
			}
			System.out.println();
		}catch(InputMismatchException ie) {
			System.out.println("Wrong Input Try Again!");
			courseOptions();
			
		}
		
	}
	
}
