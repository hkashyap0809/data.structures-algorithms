package com.kshema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDigits {

	private static void getAllCombination(int idx, List<String> keyPad, String digits, List<String> result,String str) {
		if( idx == digits.length()) {
			result.add(str);
			return;
		}

		int digit = Character.getNumericValue(digits.charAt(idx));

		//assumed that digits will be greater than 1
		if( digit >=2  ) { 
			String key = keyPad.get(digit-2);

			for( int i = 0; i< key.length(); i++) {
				getAllCombination(idx+1, keyPad, digits, result, str+key.charAt(i));
			}
		}

	}

	private static List<String> getAllCombination(String digits){
		List<String> result = new ArrayList<>();
		List<String> keyPad = List.of("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
		getAllCombination(0,keyPad,digits,result,"");
		return result;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter digits ");
		String digits= sc.nextLine();
		List<String> combinations = getAllCombination(digits);
		System.out.println(combinations);
	}

}
