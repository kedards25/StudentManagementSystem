package com.learning.niit_project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.niit_project.models.StudentModel;
import com.learning.niit_project.services.IStudentDAO;

@RestController
public class StudentController {

	@Autowired
	IStudentDAO istdDAO;
	

	
	
	@GetMapping(path="/students",produces = {"application/json"})
	@ResponseBody
	public List<StudentModel> getAllUsers() {
		//List<UserModel> model = iuserDao.findAll();
		//System.out.println("Details: "+model.size());
		return istdDAO.findAll();
	}
	
	@PostMapping(path="/students",consumes = {"application/json"})
	public ResponseEntity addDetails(@RequestBody StudentModel model) {
		istdDAO.save(model);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/students",consumes = {"application/json"})
	public ResponseEntity updateDetails(@RequestBody StudentModel model) {
		istdDAO.save(model);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/students/{id}",consumes = {"application/json"})
	public ResponseEntity deleteDetails(@PathVariable("id") int id) {
		istdDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
	
	@GetMapping(path="/students/{id}",consumes = {"application/json"})
	public Optional<StudentModel> studentById(@PathVariable("id") int id) {
		return istdDAO.findById(id);
	}
	
	
	
}
