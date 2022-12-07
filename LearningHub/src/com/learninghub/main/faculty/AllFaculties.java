package com.learninghub.main.faculty;

import java.util.List;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Faculty;

public class AllFaculties {

	public static void viewAll() {
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			List<Faculty> facultys = dao.getAllFacultyDetails();
			
			facultys.forEach( f -> {
				
				System.out.println(Style.CYAN_BOLD_BRIGHT+"\n+--------------------------------------------------+");
				System.out.println("|  Faculty Name        : " + f.getFname()+ " " + f.getLname());
				System.out.println("|  Address             : " + f.getAddress() + ", " + f.getState() + ", " + f.getPin());
				System.out.println("|  Mobile              : " + f.getMobile());
				System.out.println("|  Email               : " + f.getEmail());
				System.out.println("|  UserName            : " + f.getUsername());
				System.out.println("+--------------------------------------------------+\n"+Style.RESET);
				
			});
			System.out.println();
		} 
		catch (FacultyException e) {
			System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
		}
		

	}

}
