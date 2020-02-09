package com.learning.niit_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Table(name = "batches")
@Entity
public class BatchDetails {
	@Id
	private String batchCode;
	private String batchName;
	
	private String faculty;
	private String batchStartDate;
	private String batchEndDate;
	public BatchDetails(String batchCode, String batchName, String faculty, String batchStartDate,
			String batchEndDate) {
		super();
		this.batchCode = batchCode;
		this.batchName = batchName;
		this.faculty = faculty;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public String getBatchName() {
		return batchName;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getBatchStartDate() {
		return batchStartDate;
	}
	public String getBatchEndDate() {
		return batchEndDate;
	}
	
	
	
}
