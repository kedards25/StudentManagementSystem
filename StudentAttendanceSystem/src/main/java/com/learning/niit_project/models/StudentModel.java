package com.learning.niit_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	 private String studentName;

	    private String mobileNo;

	    private String studentMail;

	    private String course;
	    private String batch;
		public StudentModel(String studentName, String mobileNo, String studentMail, String course, String batch) {
			super();
			this.studentName = studentName;
			this.mobileNo = mobileNo;
			this.studentMail = studentMail;
			this.course = course;
			this.batch = batch;
		}
		public StudentModel() {
			super();
			// TODO Auto-generated constructor stub
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
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getStudentMail() {
			return studentMail;
		}
		public void setStudentMail(String studentMail) {
			this.studentMail = studentMail;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
	
	
	
	
}
