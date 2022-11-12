package com.learninghub.main.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;

public class UpdateBatch {

	public static void updateCourse(int batchId) {
		
		
		try (Scanner sc = new Scanner(System.in)) {
			
			boolean updated = true;
			boolean isUpdated = true;
			
			while(updated) {
				String s = "";
				
				while(true) {
					isUpdated = true;
					
					System.out.println("Select For Update.");
					System.out.println("1. Total Students");
					System.out.println("2. Start date");
					System.out.println("3. Batch Duration");
					System.out.println("4. Back");
					System.out.println("5. Exit");
					
					int i = sc.nextInt();
					
					if(i == 4) {
						updated = false;
						isUpdated = false;
						break;
					}
					else if(i == 5) {
						System.out.println("Come Back Again");
						System.exit(0);

					}
					
					if(i == 1) {
						s = "numberOfStudents";
						break;
					}
					else if(i == 2) {
						s = "batchStartDate";
						break;
					}
					else if(i == 3) {
						s = "duration";
						break;
					}
					else {
						System.out.println("Invalid Input");

						isUpdated = false;
						break;
					}

				}
				
				if(isUpdated) {
					sc.nextLine();
					System.out.print("Enter New Entry : ");
					String set = sc.nextLine();
					
					BatchDao bdo = new BatchDaoImpl();
					
					String ans;
					try {
						ans = bdo.updateBatch(s, set, batchId);
						System.out.println(ans);

					} catch (BatchException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}
				
				
				while(isUpdated) {
					System.out.println("Invalid Input");
					String urChoise = sc.next();
					
					if(urChoise.equalsIgnoreCase("y")) {
						isUpdated = true;
						break;
					}
					else if(urChoise.equalsIgnoreCase("n")) {
						updated = false;
						break;
					}
					else {
						System.out.println("Invalid Input");
					}
				}
			}
		}
		catch(InputMismatchException e){
			
			System.out.println("Invalid Inpit. Try Again");
			updateCourse(batchId);
			
		}
	}
}
