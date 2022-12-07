package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class SearchOptions {
	
	public static void searchOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {

			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|   1    |      Search By Faculty Id               |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   2    |      Search Faculty By Name             |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   3    |      View All Faculties                 |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   4    |      Back To Main Menu                  |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|   5    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			System.out.print(Style.GREEN+"Enter Your Choise : ");	
			int ch = sc.nextInt();
				
			if(ch == 1) {
					
				try {
					SearchFacultyByInt.searchById();
				} catch (InputException e) {
					System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
				}
					
			}else if(ch == 2) {
					
				SearchFacultyByName.searchByName();
					
			}else if(ch == 3) {
					
				AllFaculties.viewAll();
					
			}else if(ch == 4) {
				
				break;
				
			}else if(ch == 5) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				System.exit(0);
				
			}
			else {
				System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);	
			}
			System.out.println();	
		}
		
	}
	
}
