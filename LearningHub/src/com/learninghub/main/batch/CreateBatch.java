package com.learninghub.main.batch;

import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.exceptions.InputException;
import com.learninghub.model.Batch;


public class CreateBatch {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InputException {
		
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Batch CourseId : ");
			int courseId = sc.nextInt();
			
			System.out.print("Enter Total Students of the Batch  : ");
			int numberOfStudents = sc.nextInt();
			
			System.out.print("Enter Start Date of Batch [yyyy-MM-dd] : ");
			String date = sc.next();
			
			sc.nextLine();
			
			System.out.print("Enter Batch Duration : ");
			String duration = sc.nextLine();
			
			Batch batch = new Batch(courseId, numberOfStudents, date, duration);
			
			BatchDao bdo = new BatchDaoImpl();
			
			
			try {
				String msg = bdo.createBatch(batch);
				System.out.println(msg);
			} 
			catch (BatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());

				
			}
	
		}
		catch(Exception e) {
			throw new InputException("Invalid Input");
		}
	}
}
