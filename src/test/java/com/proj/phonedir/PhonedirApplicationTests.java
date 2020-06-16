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
		expSet.add("689");
		expSet.add("698");
		expSet.add("869");
		expSet.add("896");
		expSet.add("968");
		expSet.add("986");
		
		Mockito.when(dao.getPhoneNumberCombinations("986")).thenReturn(expSet);
		
		TreeSet<String> actSet = service.getPhoneNumberCombinations("986");
		
		assertEquals(6, actSet.size());
		
		assertLinesMatch(new ArrayList<String>(expSet), new ArrayList<String>(actSet));
		
		for(String s : actSet)
			System.out.println(s);
		
	}

}
