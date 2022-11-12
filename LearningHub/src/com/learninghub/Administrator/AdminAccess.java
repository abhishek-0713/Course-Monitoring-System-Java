package com.learninghub.Administrator;

import java.util.Scanner;

import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;
import com.learninghub.main.batch.BatchOptions;
import com.learninghub.main.batch.GenerateReport;
import com.learninghub.main.course.CourseOptions;
import com.learninghub.main.courseplan.CoursePlanOptions;
import com.learninghub.main.courseplan.ViewCoursePlan;
import com.learninghub.main.faculty.FacultyOptions;

public class AdminAccess {

	@SuppressWarnings("resource")
	public static void Access() throws InputException, FacultyException {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Courses");
			System.out.println("2. Faculty");
			System.out.println("3. Batch");
			System.out.println("4. Generate Report");
			System.out.println("5. Course Plan");
			System.out.println("6. Log Out");
			System.out.println("7. Exit");
			
			int option = sc.nextInt();
			
			if(option == 1) {
				CourseOptions.courseOptions();
			}
			else if(option == 2) {
				FacultyOptions.facultyOptions();
			}
			else if(option == 3) {
				BatchOptions.facultyOptions();
			}			
			else if(option == 4) {
				GenerateReport.viewAllBatch();
			}
			else if(option == 5) {
				CoursePlanOptions.CourseOptions();
			}
			else if(option == 6) {
				ViewCoursePlan.viewAllPlan();
			}
			else if(option == 7) {
				System.exit(0);
			}
			else {
				System.out.println("Please Select Valid Option");
				Access();
			}
		}
	}

}
