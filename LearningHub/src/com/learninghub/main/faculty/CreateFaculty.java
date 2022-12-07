package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Faculty;

public class CreateFaculty {
	
	public static void addFacultyMtd() throws InputException{
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter First Name of Faculty  : "+Style.RESET);
			String fname = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Last Name of Faculty   : "+Style.RESET);
			String lname = sc.next();
			
			sc.nextLine();
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Faculty Address        : "+Style.RESET);
			String address = sc.nextLine();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Faculty State          : "+Style.RESET);
			String state = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Faculty Pincode        : "+Style.RESET);
			String pin = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Faculty Mobile         : "+Style.RESET);
			String mobile = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Faculty Email          : "+Style.RESET);
			String email = sc.next();
			
			
			Faculty faculty = new Faculty(fname, lname, address, state, pin, mobile, email);
			
			FacultyDao dao = new FacultyDaoImpl();
			
			String result;
			try {
				result = dao.addFaculty(faculty);
				System.out.println("\n" + result + "\n");
				
			} catch (FacultyException e) {
				System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "           \n" + Style.RESET);
			}
		
		}catch(Exception e) {
			throw new InputException(Style.RED_UNDERLINED+"               Invalid Input               "+Style.RESET);			
		}
		
	}
	
}
