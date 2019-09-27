package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.service.FamilyService;

@RestController
public class FamilyDataController {
	
	@Autowired
	  FamilyService familyService;
	
	 @GetMapping(value="/getFamilyInfo")
	  public String getFamilyMembers() {
	    System.out.println("Making a call to family application");
	    return familyService.callFamilyMembersApplication();
	  }

}
