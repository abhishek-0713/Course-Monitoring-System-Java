package com.learninghub.main.facultyrights;

import java.util.Scanner;

import com.learninghub.dao.FacultyRightsDao;
import com.learninghub.dao.FacultyRightsDaoImpl;
import com.learninghub.exceptions.FacultyRightsException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Faculty;

public class FacultyLogin {
	
	public static void login() {
		Faculty faculty = null;
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=2;
		for(; i>=0; i--) {
			System.out.print(Style.TEAL+"Enter Username: "+Style.RESET);
			String uname = sc.next();
			
			System.out.print(Style.TEAL+"Enter Password: "+Style.RESET);
			String pass = sc.next();
			
			FacultyRightsDao dao = new FacultyRightsDaoImpl();
			
			try {
				faculty = dao.loginFaculty(uname, pass);
				if(faculty == null) {
					
				}else {				
					System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                  Welcome  "+faculty.getFname()+"                     \n"+Style.RESET);
					FacultyLoginOptions.facultyOption(faculty);
					return;
				}
		 	
			}catch (FacultyRightsException e) {
				System.out.println("\n           " + Style.RED_UNDERLINED+e.getMessage() + "          \n" + Style.RESET);
				System.out.println(Style.YELLOW_BOLD_BRIGHT+i+" Attempts Left \n"+Style.RESET);
				while(true) {
					
					System.out.println(Style.CYAN_BOLD_BRIGHT+"\n+--------------------------------------------------+");
					System.out.println("|   1    |      Forget My Password                 |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   2    |      Try Again                          |");
					System.out.println("+--------------------------------------------------+");
					System.out.println("|   3    |      Exit                               |");
					System.out.println("+--------------------------------------------------+\n"+Style.RESET);

					System.out.print(Style.GREEN_BOLD_BRIGHT+"Enter Your Choise : ");
					String ch = sc.next();
					
					if(ch.equals("1")) {	
						boolean check = ForgetPassword.forgetPass();
						if(check)
							return;
						else
							break;
					}else if(ch.equals("2")) {	
						break;
					}else if(ch.equals("3")) {	
						return;
					}else {
						System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n");	

					}
				}
				
			}
		}
		System.out.println(Style.RED_UNDERLINED+"\n                 Try Again!               \n");	
	}
		
}
