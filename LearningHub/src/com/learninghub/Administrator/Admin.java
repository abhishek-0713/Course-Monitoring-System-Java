package com.learninghub.Administrator;

import java.util.Scanner;

import com.learninghub.dao.AdminDao;
import com.learninghub.dao.AdminDaoImpl;
import com.learninghub.exceptions.AdminException;

public class Admin {

	@SuppressWarnings("resource")
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=2; i>=0; i--) {
			
			System.out.print("Enter Admin username : ");
			String userName = sc.next();
			
			System.out.print("Enter Password : ");
			String password = sc.next();
			
			AdminDao ado = new AdminDaoImpl();
			
			try {
				
				if(ado.login(userName, password)) {
					AdminAccess.Access();
					return;
				}
			} catch (AdminException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println(e.getMessage());
				System.out.println("You Have" + i + "attempts left to reset your password.");
				
				while(true) {
					System.out.print("Do you Want to Try Again.[Y/N] : ");
					String yn = sc.next();
					
					if(yn.equalsIgnoreCase("Y")) {
						break;
					}
					else if(yn.equalsIgnoreCase("N")) {
						return;
					}
					else {
						System.out.println("Please Enter Valid Input.");
					}
				}
			}
		}
		System.out.println("Try Again After Some Time.");
	}
}
