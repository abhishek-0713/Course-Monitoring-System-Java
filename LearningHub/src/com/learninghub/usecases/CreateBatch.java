package com.learninghub.usecases;

import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.model.Batch;

public class CreateBatch {

	public static void main(String[] args) throws Exception {
		
		try  {
			Scanner sc = new Scanner(System.in);
					
			System.out.print("Please Enter BatchId : ");
			int batchId = sc.nextInt();
			
			System.out.print("Please Enter Batch CourseId : ");
			int courseId = sc.nextInt();
			
			System.out.print("Please Enter Batch facultyId : ");
			int facultyId = sc.nextInt();
			
			System.out.print("Please Enter numberOfStudents in Batch : ");
			int numberOfStudents = sc.nextInt();
			
			System.out.print("Please Enter Batch Start Date : ");
			String batchStartDate = sc.next();
			
			System.out.print("Please Enter Batch Duration : ");
			String duration = sc.next();
			
			Batch batch = new Batch(batchId, courseId, facultyId, numberOfStudents, batchStartDate, duration );
			
			BatchDao bdo = new BatchDaoImpl();
			
			try {
				String message = bdo.createBatch(batch);
				
				System.out.println(message);
			} 
			catch (BatchException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		catch(Exception e){
			throw new Exception("Enter right input");
		}
		
	}
}
