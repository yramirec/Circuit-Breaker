package com.everis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TeacherService {
	
	@Autowired
	  private RestTemplate restTemplate;
	
	
	 @HystrixCommand(fallbackMethod =  "callTeacherApplication_Fallback")
	  public String callTeacherApplication() {
	    System.out.println("Fetching Teacher Information");
	    
	    String response = restTemplate
	        .exchange("http://localhost:8083/microservice-teacher/teachers", HttpMethod.GET
	        ,null,new ParameterizedTypeReference<String> () {},"").getBody();
	    
	    System.out.println("Response Received from Teacher Application");
	    return "NORMAL CALL Successful" + "Teacher Details: " + response;
	  }
	  
	  @SuppressWarnings("unused")
	  private String callTeacherApplication_Fallback() {
	    System.out.println("Teacher Application is down!  Fallback enabled!");
	    return "CIRCUIT BREAKER ENABLED!!  No response from Teacher Application at this time";
	  }

}
