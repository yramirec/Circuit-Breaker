package com.everis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CourseService {
	
	@Autowired
	  private RestTemplate restTemplate;
	
	
	 @HystrixCommand(fallbackMethod =  "callCourseApplication_Fallback")
	  public String callCourseApplication() {
	    System.out.println("Fetching Course Information");
	    
	    String response = restTemplate
	        .exchange("http://localhost:8084/microservice-course/courses", HttpMethod.GET
	        ,null,new ParameterizedTypeReference<String> () {},"").getBody();
	    
	    System.out.println("Response Received from Course Application");
	    return "NORMAL CALL Successful" + "Course Details: " + response;
	  }
	  
	  @SuppressWarnings("unused")
	  private String callCourseApplication_Fallback() {
	    System.out.println("Course Application is down!  Fallback enabled!");
	    return "CIRCUIT BREAKER ENABLED!!  No response from Course Application at this time";
	  }

}
