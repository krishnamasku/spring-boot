package com.proj.phonedir.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class PhoneDirectoryUtils {

	/*
	 * This method returns generated alpha numreric phone number combinations
	 * 
	 * param String
	 * 
	 * return TreeSet object
	 */
	public static TreeSet<String> getPhoneNumbersCombinations(String number) {
		
		if(number.isEmpty() || number=="")
			return null;
		
		TreeSet<String> phoneDirSet = new TreeSet<String>();

		alphaNumbericCombinations(number, phoneDirSet);

		phoneDirSet.removeIf(n -> n.equals(""));
		return phoneDirSet;
	}

	/*
	 * This method works on the logic which generates alpha numeic phone number
	 * combinations
	 * 
	 * params String, TreeSet
	 */
	public static void alphaNumbericCombinations(String phoneNumber, TreeSet<String> phoneDirSet) {

		String[] arr = phoneNumber.split("");

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i]).equals("0") || (arr[i]).equals("1")) {
				phoneDirSet.add(phoneNumber);
			} else {
				String[] temp = (lettersMap.get(phoneNumber.charAt(i))).split("");
				String[] tempArr = phoneNumber.split("");
				List<String> tempList = new ArrayList<String>();

				for (int j = 0; j < temp.length; j++) {
					tempArr[i] = temp[j];
					StringBuilder digitString = new StringBuilder();
					for (String s : tempArr)
						digitString.append(s);
					tempList.add(digitString.toString());
				}
				phoneDirSet.addAll(tempList);
			}

		}
	}

	/*
	 * This is to set constant letter values for each digit from0 to 9
	 */
	static final HashMap<Character, String> lettersMap = new HashMap<Character, String>() {
		private static final long serialVersionUID = 1L;

		{
			put('0', "");
			put('1', "");
			put('2', "ABC");
			put('3', "DEF");
			put('4', "GHI");
			put('5', "JKL");
			put('6', "MNO");
			put('7', "PQRS");
			put('8', "TUV");
			put('9', "WXYZ");
		}
	};

}
