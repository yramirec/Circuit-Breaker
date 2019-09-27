package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.everis.service.CourseService;

public class CourseDataController {
	
	@Autowired
	  CourseService courseService;
	
	 @GetMapping(value="/getCourseInfo")
	  public String getCourseMembers() {
	    System.out.println("Making a call to family application");
	    return courseService.callCourseApplication();
	  }

}
