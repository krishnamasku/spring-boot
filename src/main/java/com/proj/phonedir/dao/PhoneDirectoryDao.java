package com.proj.phonedir.dao;

import java.util.TreeSet;

public interface PhoneDirectoryDao {
	
	TreeSet<String> getPhoneNumberCombinations(String number);
	
}
