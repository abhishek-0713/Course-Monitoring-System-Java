package com.learninghub.main.faculty;

import java.util.List;
import java.util.Scanner;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Faculty;

public class SearchFacultyByName {
	
	public static boolean searchByName() {
		
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print(Style.GREEN_BOLD_BRIGHT+"Enter Faculty First Name : "+Style.RESET);
			String fname = sc.next();
			
			FacultyDao dao = new FacultyDaoImpl();
	
			
			try {
				List<Faculty> facultys = dao.searchFacultyByName(fname);
				
				facultys.forEach( f -> {
					System.out.println(Style.TEAL + "\n+--------------------------------------------------+");
					System.out.println("Faculty ID         :     " + f.getFacultyId());
					System.out.println("Faculty Name       :     " + f.getFname()+ " " + f.getLname());
					System.out.println("Faculty Address    :     " + f.getAddress() + ", " + f.getState() + ", " + f.getPin());
					System.out.println("Faculty Mobile     :     " + f.getMobile());
					System.out.println("Faculty Email      :     " + f.getEmail());
					System.out.println("Faculty Username   :     " + f.getUsername());
					System.out.println("+--------------------------------------------------+\n"+Style.RESET);				System.out.println();
					
				});
				System.out.println();
				
				
			} catch (FacultyException e) {
				System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
				return false;
			}
		return true;
		
	}
	
}
