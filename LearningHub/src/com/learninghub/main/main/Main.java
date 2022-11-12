package com.learninghub.main.main;

import java.util.Scanner;

import com.learninghub.Administrator.Admin;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;
import com.learninghub.main.faculty.FacultyLogin;

public class Main {

	public static void main(String[] args) throws InputException, FacultyException {
		
		System.out.println(" Learning Hub " + "\n");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(" 1. Admin Login " + "\n");
			System.out.println(" 2. Faculty Login " + "\n");
			System.out.println(" 3. Exit" + "\n");
			
			String option = sc.next();
			
			if(option.equals("1")) {
				Admin.login();
			}
			
			if(option.equals("2")) {
				FacultyLogin.login();
			}
			else if(option.equals("3")) {
				System.out.println("\n  Come Back Again");
				break;

			}
			else {
				System.out.println(" Please Try with Valid Option " + "\n");
			}

		}
		sc.close();
	}
}
