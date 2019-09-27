package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.service.StudentService;

@RestController
public class StudentDataController {
	
	@Autowired
	  StudentService studentService;
	
	 @GetMapping(value="/getStudentInfo")
	  public String getStudents() {
	    System.out.println("Making a call to students application");
	    return studentService.callStudentApplication();
	  }

}
