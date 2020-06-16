package com.proj.phonedir.service;

import java.util.TreeSet;

public interface PhoneDirectoryService {
	
	TreeSet<String> getPhoneNumberCombinations(String number);
	
}
