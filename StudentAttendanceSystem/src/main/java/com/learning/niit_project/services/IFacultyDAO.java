package com.learning.niit_project.services;

import org.springframework.data.repository.CrudRepository;

import com.learning.niit_project.models.FacultyModel;

public interface IFacultyDAO extends CrudRepository<FacultyModel, Integer> {

}
