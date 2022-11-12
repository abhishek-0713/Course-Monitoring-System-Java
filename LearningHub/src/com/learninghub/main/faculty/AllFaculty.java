package com.learninghub.main.faculty;

import java.util.List;

import com.learninghub.dao.FacultyDao;
import com.learninghub.dao.FacultyDaoImpl;
import com.learninghub.exceptions.FacultyException;
import com.learninghub.model.Faculty;

public class AllFaculty {


	public static void viewAll() {
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			List<Faculty> facultys = dao.allFaculty();
			
			facultys.forEach( f -> {
				
				System.out.println();
				System.out.println("Faculty ID : " + f.getFacultyId());
				System.out.println("Faculty Name : " + f.getFacultyName());
				System.out.println("Faculty Address : " + f.getFacultyAddress());
				System.out.println("Faculty Mobile : " + f.getMobile());
				System.out.println("Faculty Email : " + f.getEmail());
				System.out.println("Faculty Username : " + f.getUsername());
				
			});
			System.out.println();
		} 
		catch (FacultyException fe) {
			System.out.println(fe.getMessage());
		}
		

	}

}
