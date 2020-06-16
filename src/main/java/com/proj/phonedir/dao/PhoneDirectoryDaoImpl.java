package com.proj.phonedir.dao;

import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.proj.phonedir.utils.PhoneDirectoryUtils;

@Component
public class PhoneDirectoryDaoImpl implements PhoneDirectoryDao {

	@Override
	public TreeSet<String> getPhoneNumberCombinations(String number) {
		return PhoneDirectoryUtils.getPhoneNumbersCombinations(number);
	}
	
}
