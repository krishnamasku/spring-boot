package com.proj.phonedir.service;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.phonedir.dao.PhoneDirectoryDao;

@Service
public class PhoneDirectoryServiceImpl implements PhoneDirectoryService {

	@Autowired
	private PhoneDirectoryDao phoneDirectoryDao; 
	
	@Override
	public TreeSet<String> getPhoneNumberCombinations(String number) {
		return phoneDirectoryDao.getPhoneNumberCombinations(number);
	}

}
