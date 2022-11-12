package com.learninghub.main.courseplan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.learninghub.dao.CoursePlanDao;
import com.learninghub.dao.CoursePlanDaoImpl;
import com.learninghub.exceptions.CoursePlanException;
import com.learninghub.utility.DBUtil;

public class UpdateDate {

public static void updateDate(int facultyId) {
		

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("SELECT batchId FROM Batch WHERE facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			List<Integer> arr = new ArrayList<>();
			while(rs.next()) {
				arr.add(rs.getInt("batchId"));
			}
			
			if(arr.size()==0) {
				System.out.println(facultyId + "is not Allocated to Any Batch");
				return;
			}
			
			System.out.print("Choose Batch Id : ");
			for(int i = 0; i < arr.size(); i++) {
				System.out.println((i+1)+". " +arr.get(i));
			}
			
			int ch = sc.nextInt();
			int batchId = arr.get(ch-1);
			
			System.out.print("Enter the old day no : ");
			int dayNo = sc.nextInt();
			
			System.out.print("Enter the New day no : ");
			int newDay = sc.nextInt();
			
			CoursePlanDao dao = new CoursePlanDaoImpl();
			
			try {
				String res = dao.updateDate(batchId, dayNo, newDay);
				System.out.println(res);
				
			} catch (CoursePlanException e) {
				System.out.println( e.getMessage());
				
			}
			
		}catch (Exception e) {
			System.out.println("Please Enter Right Input");
			updateDate(facultyId);
		}
		
	}

}
