package com.learninghub.main.batch;

import java.util.List;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.model.Batch;

public class ViewAllBatch {

	public static void viewAllBatch() {
		BatchDao bdo = new BatchDaoImpl();
		
		try {
			List<Batch> batchList = bdo.viewallBatch();
			
			batchList.forEach(b -> {
				System.out.println(b.getBatchId() + " " +  b.getCourseId() + " " +  b.getFacultyId() + " " + b.getNumberOfStudents() + " " + b.getBatchStartDate() + " " + b.getDuration());
			});

		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}
}
