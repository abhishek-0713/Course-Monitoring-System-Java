package com.learninghub.main.courseplan;

import java.util.List;

import com.learninghub.dao.CoursePlanDao;
import com.learninghub.dao.CoursePlanDaoImpl;
import com.learninghub.exceptions.CoursePlanException;
import com.learninghub.model.coursePlan;

public class ViewCoursePlanPerDay {

	public static void viewAllPlan(String date) {
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		try {
			List<coursePlan> plans = dao.viewCoursePlanperDay(date);

			plans.forEach(e -> {
				System.out.printf("%5s %13s %6s %20s %14s %8s", e.getPlanId(), e.getBatchId(), e.getDayNumber(), e.getCptopic(), e.getCpDate(), e.isStatus());				
			});
			System.out.println();
			
		} catch (CoursePlanException e) {
			System.out.println( e.getMessage());			
		}
		
	}

	
}
