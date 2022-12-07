package com.learninghub.adminnistrator;

import java.util.Scanner;

import com.learninghub.dao.AdminDao;
import com.learninghub.dao.AdminDaoImpl;
import com.learninghub.exceptions.AdminException;
import com.learninghub.extrafeatures.Style;

public class AdminLogin {
	
	public static void LoginAdmin(){
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=2;
		for(; i>=0; i--) {
			
			System.out.print(Style.CYAN+"\nEnter Username: ");
			String uname = sc.next();
			
			System.out.print(Style.CYAN+"Enter Password: ");
			String pass = sc.next();
			
			System.out.println();

			AdminDao dao = new AdminDaoImpl();
			
			try {
				boolean flag = dao.LoginAdmin(uname, pass);
				if(flag) {
					System.out.println(Style.GREEN_BOLD_BRIGHT+"Login Successful" + Style.RESET);
					AdminAccess.adminOption();
					return;
				}
		 	
			}catch (AdminException e) {
		
				System.out.println("\n" + Style.RED_UNDERLINED+e.getMessage()+ "\n");
				System.out.println(Style.YELLOW_BOLD+i+" Attempts Left " + Style.RESET);
			
				while(true) {
					System.out.print(Style.GREEN+"Do you Want to try again?(y/n) : "+Style.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						return;
					}else {
						
						System.out.println(Style.RED_UNDERLINED+" Wrong Input!"+Style.RESET);
						
					}
				}
			}
		}
		System.out.println(Style.RED_UNDERLINED+"\n Try Again After Some Time. \n"+Style.RESET);
	}
	
}
