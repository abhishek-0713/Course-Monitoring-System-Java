package com.learninghub.adminnistrator;

import java.util.Scanner;

import com.learninghub.extrafeatures.Style;
import com.learninghub.main.batch.BatchOptions;
import com.learninghub.main.batch.GenerateReport;
import com.learninghub.main.course.CourseChoice;
import com.learninghub.main.courseplan.CoursePlanOptions;
import com.learninghub.main.courseplan.ViewAllPlanDayWise;
import com.learninghub.main.faculty.FacultyOptions;

public class AdminAccess {
	
	public static void adminOption() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n        Welcome to Learning Hub Course Platform       \n" + Style.RESET);

		while(true) {
			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|  1  |     Courses                                |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  2  |     Faculty                                |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  3  |     Batch                                  |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  4  |     Course Plan                            |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  5  |     View Day wise Planner                  |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  6  |     Generate Report                        |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  7  |     Log Out                                |");
			System.out.println("+--------------------------------------------------+");
			System.out.println("|  8  |     Close the App                          |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);
			
			System.out.print(Style.GREEN+"Enter Your Choise : ");	
			int ch = sc.nextInt();
		
			if(ch == 1) {
				CourseChoice.courseOptions();

			}else if(ch == 2) {
				FacultyOptions.facultyOptions();

			}else if(ch == 3) {
				BatchOptions.facultyOptions();
	
			}else if(ch == 4) {
				CoursePlanOptions.CourseOptions();

			}else if(ch == 5) {
				ViewAllPlanDayWise.viewAllPlan();

			}else if(ch == 6) {
				GenerateReport.viewAllBatch();

			}else if(ch== 8) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again                    "+Style.RESET);
				System.exit(0);
				
			}else if(ch == 7) {
				break;
				
			}
			else {
				System.out.println(Style.RED_UNDERLINED+"\n                Wrong Input Try Again!                \n"+Style.RESET);
				adminOption();
			}
			
		}
		
		
	}
	
}
