package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.exceptions.InputException;

public class FacultyOptions {

	public static void facultyOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1. Add Faculty");
			System.out.println("2. Update Faculty");
			System.out.println("3. All Faculty");
			System.out.println("4. Back");
			System.out.println("5. Close");
			
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					CreateFaculty.createFaculty();
					
				} catch (InputException e) {
					System.out.println(e.getMessage());					
				}
				
			}else if(ch == 2) {
				UpdateFaculty.UpdateById(ch);
				
			}else if(ch == 3) {
				AllFaculty.viewAll();
				
			}else if(ch== 5) {
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 6) {
				break;
				
			}else {
				System.out.println("Wrong Input Try Again");				
			}
		}
		
	}
	
}
