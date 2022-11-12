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
		int i=4;
		for(; i>=0; i--) {
			
			System.out.println(Style.CYAN+"Enter Username:"+Style.RESET);
			String uname = sc.next();
			
			System.out.println(Style.CYAN+"Enter Password:"+Style.RESET);
			String pass = sc.next();
			
			AdminDao dao = new AdminDaoImpl();
			
			try {
				boolean flag = dao.LoginAdmin(uname, pass);
				if(flag) {
					AdminAccess.adminOption();
					return;
				}
		 	
			}catch (AdminException e) {
				System.out.println();
				System.out.println(Style.RED_BACKGROUND+e.getMessage()+Style.RESET);
				System.out.println();
				System.out.println(Style.YELLOW+i+" Attempts Left.."+Style.RESET);
				System.out.println();
				while(true) {
					System.out.println(Style.CYAN+"Want to try again?(y/n)"+Style.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						return;
					}else {
						System.out.println();
						System.out.println(Style.RED+"Wrong Input...!"+Style.RESET);
						System.out.println();
					}
				}
			}
		}
		System.out.println();
		System.out.println(Style.YELLOW+"Try After 5 minutes.."+Style.RESET);
		System.out.println();
	}
	
}
