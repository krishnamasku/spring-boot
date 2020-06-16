package com.proj.phonedir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.proj.phonedir.dao.PhoneDirectoryDaoImpl;
import com.proj.phonedir.service.PhoneDirectoryServiceImpl;

@SpringBootTest
class PhonedirApplicationTests {
	
	@Mock
	private PhoneDirectoryDaoImpl dao; 
	
	@InjectMocks
	private PhoneDirectoryServiceImpl service;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetCombinations() {
		TreeSet<String> expSet = new TreeSet<>();
		expSet.add("3866106");
		expSet.add("386610M");
		expSet.add("386610N");
		expSet.add("386610O");
		expSet.add("386M106");
		expSet.add("386N106");
		expSet.add("386O106");
		expSet.add("38M6106");
		expSet.add("38N6106");
		expSet.add("38O6106");
		expSet.add("3T66106");
		expSet.add("3U66106");
		expSet.add("3V66106");
		expSet.add("D866106");
		expSet.add("E866106");
		expSet.add("F866106");
		
		Mockito.when(dao.getPhoneNumberCombinations("3866106")).thenReturn(expSet);
		
		TreeSet<String> actSet = service.getPhoneNumberCombinations("3866106");
		
		assertEquals(expSet.size(), actSet.size());
		
		assertLinesMatch(new ArrayList<String>(expSet), new ArrayList<String>(actSet));
		
	}

}
