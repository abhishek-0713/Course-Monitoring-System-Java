package com.learninghub.main.batch;

import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.exceptions.InputException;
import com.learninghub.model.Batch;

public class SearchBatchById {

	public static void searchBatch() throws InputException{
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.print(" Enter BatchId : ");
			int batchId = sc.nextInt();
			
			BatchDao bdo = new BatchDaoImpl();
			
			try {
				Batch b = bdo.searchBatchById(batchId);
				
				System.out.printf(" " + b.getBatchId(), b.getCourseId(), b.getFacultyId(), b.getNumberOfStudents(), b.getBatchStartDate(), b.getDuration() + " \n");
				

			} catch (BatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());

			}
		}
		catch(Exception e) {
			throw new InputException("Please Enter Valid Input");
		}

	}
}
