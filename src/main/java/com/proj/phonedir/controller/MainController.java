package com.proj.phonedir.controller;

import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phonedir.service.PhoneDirectoryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MainController {
	
	@Autowired
	private PhoneDirectoryService phoneDirectoryService;
	
	@GetMapping(value={"/phone/{number}"}, produces="application/json")
	public TreeSet<String> getPhoneNumbers(@PathVariable String number, HttpSession session){
		session.invalidate();
		return phoneDirectoryService.getPhoneNumberCombinations(number);
	}
	
}
