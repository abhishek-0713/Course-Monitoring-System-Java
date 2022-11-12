package com.learninghub.main.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.utility.DBUtil;

public class AllocateFaculty {

	public static void allocateFaculty() {
		

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		

		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.print("Enter the Faculty Id : ");
			int facultyId = sc.nextInt();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Faculty WHERE facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
			boolean isAllocated = rs.next();
			
			if(isAllocated) {
				
				while(isAllocated) {
					
					System.out.print("Enter the Batch Id : ");
					int batchId = sc.nextInt();
					
					BatchDao dao = new BatchDaoImpl();
					
					try {
						String res = dao.allocateFaculty(facultyId, batchId);
				
						System.out.println(res);
						isAllocated = false;
						
					} catch (BatchException e) {	
						System.out.println( e.getMessage());		
					}
		
				}
				
			}else {
			
				System.out.println("Faculty is Not Present \n");
				
				allocateFaculty();
			}
			
		}catch(Exception ie) {
			System.out.println("Wrong Input Try Again!");
			allocateFaculty();
		}
	}
}
