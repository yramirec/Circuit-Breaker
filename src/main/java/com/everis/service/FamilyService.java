package com.everis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FamilyService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callFamilyApplication_Fallback")
	public String callFamilyMembersApplication() {
		System.out.println("Fetching Family Information");

		String response = restTemplate.exchange("http://localhost:8082/microservice-family/families", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, "").getBody();

		System.out.println("Response Received from Family Application");
		return "NORMAL CALL Successful" + "Family Details: " + response;
	}

	@SuppressWarnings("unused")
	private String callFamilyMembersApplication_Fallback() {
		System.out.println("Family Application is down!  Fallback enabled!");
		return "CIRCUIT BREAKER ENABLED!!  No response from Family Application at this time";
	}

}
