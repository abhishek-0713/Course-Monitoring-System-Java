package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.dao.FacultyAccess;
import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.model.Faculty;

public class FacultyLogin {

	
	public static void login() {
		Faculty faculty = null;
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			System.out.print("Enter Username: ");
			String uname = sc.next();
			
			System.out.print("Enter Password: ");
			String pass = sc.next();
			
			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				faculty = dao.login(uname, pass);
			} 
			catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(faculty == null) {
				
			}else {				
				System.out.println(" Welcome "+faculty.getFacultyName()+" ");
				FacultyAccess.Access(faculty);
				return;
			}
		}
		System.out.println("Try After 5 minutes..");
	}
	
	
}
