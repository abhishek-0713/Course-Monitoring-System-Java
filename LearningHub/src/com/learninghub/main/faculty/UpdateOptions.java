package com.learninghub.main.faculty;


import java.util.Scanner;

import com.learninghub.extrafeatures.Style;



public class UpdateOptions {
	
	public static void updateOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {	

			System.out.println(Style.CYAN+"1. ");
			System.out.println("2. Update By Name");
			System.out.println("3. Back");
			System.out.println("4. Close" +Style.RESET);
			
			System.out.println(Style.CYAN_BOLD_BRIGHT+"Update : ");
			
			System.out.println(Style.CYAN_BOLD_BRIGHT+"\n+--------------------------------------------------+");
			System.out.println("|   1    |      Update By Faculty Id               |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   2    |      Update By Name                          |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   3    |      Back To Main Menu                  |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   4    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			System.out.print(Style.GREEN+"Enter Your Choise : ");
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					System.out.println(Style.BLUE_BOLD_BRIGHT+"Enter id of Faculty    : "+Style.RESET);
					int id = sc.nextInt();
					
					UpdateFaculty.UpdateById(id);
				}catch(Exception e) {
					System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	
					updateOptions();
				}
				
			}else if(ch == 2) {
				if(SearchFacultyByName.searchByName()) {
					
					try {
						System.out.println(Style.BLUE_BOLD_BRIGHT+"Enter id of Faculty    : "+Style.RESET);
						int id = sc.nextInt();
						UpdateFaculty.UpdateById(id);
					}catch(Exception e) {
						System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	
						updateOptions();
					}
				}else {
					updateOptions();
				}
				
			}else if(ch== 4) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}else {
				System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	
			}
			
		}
		
		
	}
	
}
