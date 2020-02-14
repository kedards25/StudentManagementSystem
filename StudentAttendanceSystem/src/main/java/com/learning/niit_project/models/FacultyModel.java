package com.learning.niit_project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	public FacultyModel(int facultyId, String facultyName, String facultyPwd, String courseName, String batchName,
			String facultyEmail, long facultyContact) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyPwd = facultyPwd;
		this.courseName = courseName;
		this.batchName = batchName;
		this.facultyEmail = facultyEmail;
		this.facultyContact = facultyContact;
	}
	
	public FacultyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
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
	public String getFacultyPwd() {
		return facultyPwd;
	}
	public void setFacultyPwd(String facultyPwd) {
		this.facultyPwd = facultyPwd;
	}

	@Override
	public String toString() {
		return "FacultyModel [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyPwd=" + facultyPwd
				+ ", courseName=" + courseName + ", batchName=" + batchName + ", facultyEmail=" + facultyEmail
				+ ", facultyContact=" + facultyContact + "]";
	}
	
}
