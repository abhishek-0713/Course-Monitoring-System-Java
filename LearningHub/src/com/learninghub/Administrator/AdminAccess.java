package com.learninghub.Administrator;

import java.util.Scanner;

public class AdminAccess {

	@SuppressWarnings("resource")
	public static void Access() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("A] Courses");
			System.out.println("B] Batch");
			System.out.println("C] Faculty");
			System.out.println("D] Course Plan");
			System.out.println("E] Generate Report");
			System.out.println("F] Log Out");
			System.out.println("G] Exit");
			
			int option = sc.nextInt();
			
			if(option == 1) {
				
			}
			else if(option == 2) {
				
			}
			else if(option == 3) {
				
			}			
			else if(option == 4) {
				
			}
			else if(option == 5) {
				
			}
			else if(option == 6) {
				
			}
			else if(option == 7) {
				System.exit(0);
			}
			else {
				System.out.println("Please Select Valid Option");
				Access();
			}
		}
	}

}
