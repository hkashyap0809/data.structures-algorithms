package com.kshema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AtleastTwice {
	
	
	public static boolean atleastTwice(List<Long> nums) {
		
		HashMap<Long, Long> hashMap = new HashMap<Long, Long>();
		for( long num : nums ) {
			if( hashMap.containsKey(num))	return true;
			hashMap.put(num, hashMap.getOrDefault(num, 0L)+1L);
		}
		return false;
	}
	public static void main(String[] args) {
//		long[] nums = {24234234,234,534,645,7,1154,235,234234,79,456,654345,6456};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter comma separated integers");
		String[] numStr = sc.next().split(",");
		List<Long> nums = new ArrayList<Long>();
		for( String num : numStr ) {
			nums.add(Long.parseLong(num));
		}
		
		boolean result =  atleastTwice(nums);
		System.out.println(result);
	}

}
