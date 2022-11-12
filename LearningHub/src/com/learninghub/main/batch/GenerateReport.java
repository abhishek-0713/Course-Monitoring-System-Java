package com.learninghub.main.batch;

import java.util.List;

import com.learninghub.dao.BatchDao;
import com.learninghub.dao.BatchDaoImpl;
import com.learninghub.exceptions.BatchException;
import com.learninghub.model.generateReport;

public class GenerateReport {

	public static void viewAllBatch() {
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			List<generateReport> batches = dao.generateReportFromBatch();
			
			batches.forEach( b -> {
				System.out.printf("\n%12s %8s %12s %15s %20s %11s %10s %12s", b.getBatchId(), b.getCourseId(), b.getNoOfStudents(), b.getBatchstartDate(), b.getDuration(), b.getCompleted() + "\n");				
			});
				
		}
		catch (BatchException e) {
			System.out.println("\n"+e.getMessage()+"\n");
		}
	}
}
