package com.learninghub.dao;

import java.util.List;

import com.learninghub.exceptions.BatchException;
import com.learninghub.model.Batch;
import com.learninghub.model.generateReport;

public class BatchDaoImpl implements BatchDao {
	
	///// ****************        CREATE BATCH          ************* /////
	@Override
	public String createBatch(Batch batch) throws BatchException {
		return null;
		
	}

	
	///// ****************        UPDATE BATCH          ************* /////
	@Override
	public String updateBatch (String str, String set, String batchId) throws BatchException {
		return batchId;
		
	}

	
	///// ****************        SEARCH BATCH          ************* /////
	@Override
	public Batch searchBatchById(String id) throws BatchException {
		return null;
		
	}

	
	///// ****************        VIEW BATCH          ************* /////
	@Override
	public List<Batch> viewallBatch() throws BatchException {
		return null;
		
	}

	
	///// ****************        ALLOCATE FACULTY TO A BATCH          ************* /////
	@Override
	public String allocateFaculty(int fName, String batchId) throws BatchException {
		return batchId;
		
	}
	
	
	///// ****************        GEANERATE REPORT FOR EVERY BATCH          ************* /////
	@Override
	public List<generateReport> generateReportFromBatch() throws BatchException {
		return null;
		
	}
	
	
	///// ****************        DELETE BATCH          ************* /////
	@Override
	public String deleteBatch(String batchId) throws BatchException {
		return batchId;
		
	}


}
