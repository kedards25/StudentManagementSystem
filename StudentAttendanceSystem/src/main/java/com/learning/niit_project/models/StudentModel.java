package com.learning.niit_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentModel {

	@Id
	private int studentId;
	private String studentName;
	private String batch;
	
	
	
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentModel(int studentId, String studentName, String batch) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.batch = batch;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", batch=" + batch + "]";
	}
	
}
