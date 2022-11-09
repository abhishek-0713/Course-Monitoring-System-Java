package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.BatchException;
import com.learninghub.model.Batch;
import com.learninghub.model.generateReport;

public interface BatchDao {

	public String createBatch(Batch batch) throws BatchException;

	public String updateBatch (String str, String set, String batchId) throws BatchException;

	public Batch searchBatchById(String id) throws BatchException;

	public List<Batch> viewallBatch() throws BatchException;

	public String allocateFaculty(int fName, String batchId) throws BatchException;
	
	public List<generateReport> generateReportFromBatch() throws BatchException;
	
	public String deleteBatch(String batchId) throws BatchException;

	
}
