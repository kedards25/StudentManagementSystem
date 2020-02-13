package com.learning.niit_project.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QR_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int QR_id=0;
	private String facultyName;
	private String CourseName;
	private String BatchCode;
	private Date currentDateTime;
	
	public QR_Details(String facultyName, String courseName, String batchCode, Date currentDateTime) {
		super();
		this.facultyName = facultyName;
		CourseName = courseName;
		BatchCode = batchCode;
		this.currentDateTime = currentDateTime;
	}
	public QR_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQR_id() {
		return QR_id;
	}
	public void setQR_id(int qR_id) {
		QR_id = qR_id;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getBatchCode() {
		return BatchCode;
	}
	public void setBatchCode(String batchCode) {
		BatchCode = batchCode;
	}
	public Date getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(Date currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	@Override
	public String toString() {
		return "QR_Details [QR_id=" + QR_id + ", facultyName=" + facultyName + ", CourseName=" + CourseName
				+ ", BatchCode=" + BatchCode + ", currentDateTime=" + currentDateTime +"]";
	}
	
	
	
	
}
