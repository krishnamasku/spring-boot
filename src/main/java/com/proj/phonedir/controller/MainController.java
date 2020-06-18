package com.proj.phonedir.controller;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phonedir.service.PhoneDirectoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {

	@Autowired
	private PhoneDirectoryService phoneDirectoryService;

	@GetMapping(value = { "/phone/{number}" }, produces = "application/json")
	public ResponseEntity<?> getPhoneNumbers(@PathVariable String number) {
		TreeSet<String> resultSet = new TreeSet<String>();
		ResponseEntity<?> resEntity = null;

		if ((number != null || !"".equals(number)) && (number.length() == 7 || number.length() == 10))
			resultSet = phoneDirectoryService.getPhoneNumberCombinations(number);

		if (!resultSet.isEmpty()) {
			resEntity = new ResponseEntity<TreeSet<String>>(resultSet, new HttpHeaders(), HttpStatus.OK);
		} else {
			resEntity = new ResponseEntity<String>("Invalid phone number", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resEntity;
	}

}
