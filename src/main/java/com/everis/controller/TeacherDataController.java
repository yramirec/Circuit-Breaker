package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.everis.service.TeacherService;

public class TeacherDataController {
	
	@Autowired
	  TeacherService teacherService;
	
	 @GetMapping(value="/getTeacherInfo")
	  public String getCourse() {
	    System.out.println("Making a call to teacher application");
	    return teacherService.callTeacherApplication();
	  }


}
