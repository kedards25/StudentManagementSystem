package com.learning.niit_project.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.FaultAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.niit_project.models.FacultyModel;
import com.learning.niit_project.services.IFacultyDAO;

@Controller
public class FacultyController {

	@Autowired
	IFacultyDAO iFacultyDAO;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String index(@RequestParam("facultyId") int facultyId, @RequestParam("pwd") String facultyPass,HttpServletRequest request) {
		Optional<FacultyModel> model= iFacultyDAO.findById(facultyId);
		if(model.isPresent())
		{
			FacultyModel faculty=model.get();
			int id=faculty.getFacultyId();
			String password=faculty.getFacultyPwd();
			if (facultyId==id&&facultyPass.equals(password)) {
				HttpSession session=request.getSession();
				session.setAttribute("facultyName", faculty.getFacultyName());
				return "qr-details"; 
			}
				
		}

			return "index";	
	}

	@PostMapping("/generate_qr")
	public String generateQR() {
		
		return "generate-qr";
	}

}
