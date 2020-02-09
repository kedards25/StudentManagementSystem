package com.learning.niit_project.controllers;

import javax.xml.ws.FaultAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.niit_project.models.FacultyModel;

@Controller
public class FacultyController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String index(@RequestBody("email") String facultyEmail, @RequestBody("pwd") String facultyPass) {
		if (facultyEmail.equals("niit.kedar@gmail.com") && facultyPass.equals("Pass@123")) {
			return "qr-details";
		}
		return "index";

	}

	@RequestMapping("generate_qr")
	public String generateQR() {
		return "";
	}

}
