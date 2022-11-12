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
				
				System.out.println();
				System.out.println(Style.ORANGE+"Faculty ID : " + f.getFacultyId());
				System.out.println("Faculty Name : " + f.getFname()+ " " + f.getLname());
				System.out.println("Faculty Address : " + f.getAddress() + ", " + f.getState() + ", " + f.getPin());
				System.out.println("Faculty Mobile : " + f.getMobile());
				System.out.println("Faculty Email : " + f.getEmail());
				System.out.println("Faculty Username : " + f.getUsername());
				System.out.println("------------------------------"+Style.RESET);
				
			});
			System.out.println();
		} catch (FacultyException fe) {
			System.out.println();
			System.out.println(Style.RED_BACKGROUND+fe.getMessage()+Style.RESET);
			System.out.println();
		}
		

	}

}
