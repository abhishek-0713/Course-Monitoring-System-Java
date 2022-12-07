package com.learninghub.main.faculty;

import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;
import com.learninghub.extrafeatures.Style;

public class DeleteFaculty {
	
public static void deleteFaculty() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print(Style.GREEN_BOLD_BRIGHT+"Enter id of Faculty  : "+Style.RESET);
			int id = sc.nextInt();
			
			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				String res = dao.deleteFaculty(id);
				System.out.println("\n" + res + "\n");
				
			} catch (FacultyException e) {
				System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
			}
			
		} 
		catch(Exception e) {
			throw new InputException(Style.RED_UNDERLINED+"               Invalid Input               "+Style.RESET);						
		}
	}
	
}
