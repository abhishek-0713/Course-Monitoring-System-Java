package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;
import com.learninghub.model.Faculty;

public class CreateFaculty {

	public static void createFaculty() throws InputException{
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter  Name of Faculty : ");
			String fname = sc.next();
			
			sc.nextLine();
			System.out.print("Enter Faculty Address : ");
			String address = sc.nextLine();
			
			
			System.out.print("Enter Faculty Mobile No. : ");
			String mobile = sc.next();
			
			System.out.print("Enter Faculty Email : ");
			String email = sc.next();
			
			
			Faculty faculty = new Faculty(fname, address, mobile, email);
			
			FacultyDao dao = new FacultyDaoImpl();
			
			String result;
			try {
				result = dao.createFaculty(faculty);
				System.out.println(result);
				
			} catch (FacultyException e) {
				System.out.println(e.getMessage());
			}
		
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input");
			
		}
		
	}
	
}
