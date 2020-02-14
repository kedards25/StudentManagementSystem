package com.learning.niit_project.services;

import org.springframework.data.jpa.repository.JpaRepository;


import com.learning.niit_project.models.StudentModel;

public interface IStudentDAO extends JpaRepository<StudentModel, Integer> {

}
