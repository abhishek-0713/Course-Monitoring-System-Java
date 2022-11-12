package com.learninghub.main.batch;

import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.exceptions.InputException;

public class DeleteBatch {

	public static void deleteBatch() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter id of Batch : ");
			int batchId = sc.nextInt();
			
			BatchDao dao = new BatchDaoImpl();
			
			try {
				String res = dao.deleteBatch(batchId);
			
				System.out.println(res);
				
			} catch (BatchException e) {
				System.out.println(e.getMessage());
				
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input");
			
		}
	}
	
}
