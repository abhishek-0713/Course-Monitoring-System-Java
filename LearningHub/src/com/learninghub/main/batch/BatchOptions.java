package com.learninghub.main.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learninghub.exceptions.FacultyException;
import com.learninghub.exceptions.InputException;

public class BatchOptions {

	public static void facultyOptions() throws InputException, FacultyException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add Batch");
				System.out.println("2. Update Batch");
				System.out.println("3. Search Batch");
				System.out.println("4. Delete Batch");
				System.out.println("5. Allocate Faculty");
				System.out.println("6. Back");
				System.out.println("7. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						CreateBatch.main(null);
					} 
					catch (InputException e) {
						System.out.println(e.getMessage());
					}
				}else if(ch == 2) {
					
					System.out.print("Enter name of Course : ");
					String s = sc.next();
					int batchId = Integer.parseInt(s);
					
					UpdateBatch.updateCourse(batchId);
					
				}else if(ch == 3) {
					SearchBatchById.searchBatch();
					
				}else if(ch == 4) {
					try {
						DeleteBatch.deleteBatch();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 5) {
					AllocateFaculty.allocateFaculty();
					
				}else if(ch == 6) {
					break;
					
				}else if(ch == 7) {
					System.out.println("See You Soon...");
					System.exit(0);
					
				}else {
					System.out.println("Wrong Input Try Again!");
					
				}
				
			}
		}catch(InputMismatchException ie) {
			System.out.println("Wrong Input Try Again!");
			facultyOptions();
			
		}
		
	}
	
}
