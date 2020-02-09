package com.learning.niit_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacultyModel {

	@Id
	private int facultyId;
	private String facultyName;
	private String facultyPwd;
	private String courseName;
	private String batchName;
	private String facultyEmail;
	private long facultyContact;
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public long getFacultyContact() {
		return facultyContact;
	}
	public void setFacultyContact(long facultyContact) {
		this.facultyContact = facultyContact;
	}

	
	
}
