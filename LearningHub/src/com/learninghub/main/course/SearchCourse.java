package com.learninghub.main.course;

import com.learninghub.dao.CourseDao;
import com.learninghub.dao.CourseDaoImpl;
import com.learninghub.exceptions.CourseException;
import com.learninghub.model.Course;

public class SearchCourse {

	public static boolean searchByName(String name)  {
		
		boolean flag = false;

			CourseDao dao = new CourseDaoImpl();
			
			Course c;
			try {
				c = dao.searchCourse(name);
				if(c != null) {
					flag = true;
				}
				
			} catch (CourseException e) {
				return flag;
				
			}
				
				
		
		return flag;
		
	}
	
}
