package com.learninghub.main.faculty;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.extrafeatures.Style;

public class UpdateFaculty {
	

	public static void UpdateById(int id) {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			boolean flag2 = true;
			
			while(flag) {
				
				String str = "";
	
				
				while(true) {	
					
					System.out.println(Style.CYAN_BOLD_BRIGHT+"Update : ");
					
					System.out.println(Style.WHITE_BOLD_BRIGHT+"\n+--------------------------------------------------+");
					System.out.println("|   1    |      First Name                         |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   2    |      Last Name                          |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   3    |      Address                            |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   4    |      State                              |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   5    |      Pin Code                           |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   6    |      Mobile                             |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   7    |      Email                              |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   8    |      Back To Main Menu                  |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   9    |      Exit                               |");
					System.out.println("+--------------------------------------------------+\n"+Style.RESET);

					System.out.print(Style.GREEN+"Enter Your Choise : ");	
					int ch = sc.nextInt();
					
					if(ch == 8) {
						flag = false;
						flag2 = false;
						break;
						
					}else if(ch== 9) {
						System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
						System.exit(0);	
					}
				
					if(ch == 1) {
						str = "facultyFname";
						break;
					}else if(ch == 2) {
						str = "facultyLname";
						break;
					}else if(ch == 3) {
						str = "facultyAddress";
						break;
					}else if(ch == 4) {
						str = "facultyState";
						break;
					}else if(ch == 5) {
						str = "facultyPin";
						break;
					}else if(ch == 6) {
						str = "mobile";
						break;
					}else if(ch == 7) {
						str = "email";
						break;
					}
					else {
						System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);
					}
				}
				
				if(flag2) {
					sc.nextLine();
					System.out.print("Enter New Entry :");
					String set = sc.nextLine();
					
					FacultyDao dao = new FacultyDaoImpl();
					
					String result;
					try {
						result = dao.updateFacultyDetails(str, set, id);
						System.out.println("\n" + result + "\n");
						
					} catch (FacultyException e) {
						System.out.println("\n           " + Style.RED_BOLD_BRIGHT+e.getMessage() + "          \n" + Style.RESET);
					}
					
				}
				
				
				while(flag2) {
					System.out.print(Style.GREEN_BOLD_BRIGHT+"Update More Feilds [y/n] : "+Style.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						flag = false;
						break;
					}else {
						System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);
					}
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("\n               Invalid Input Try Again!               \n"+Style.RESET);
			UpdateById(id);
		}

	}
	
}
