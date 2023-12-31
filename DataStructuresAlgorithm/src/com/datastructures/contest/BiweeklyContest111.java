package com.datastructures.contest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BiweeklyContest111 {

	public boolean canMakeSubsequence(String str1, String str2) {
		int i = 0;
		int j = 0;
		int n1 = str1.length();
		int n2 = str2.length();

		while( i<n1 && j<n2) {
			if( characterEqual(i,j,str1,str2) ) {
				i++;
				j++;
			}else{
				i++;
			}
		}

		if( j==n2 )return true;
		return false;
	}

	private boolean characterEqual(int i, int j, String str1, String str2) {
		char ch1 = str1.charAt(i);
		char ch2 = str2.charAt(j);

		if( ch1 == ch2 )return true;
		if( (int)ch1 + 1 == (int)ch2) return true;
		if( ch1=='z' && ch2 =='a' )return true;

		return false;
	}

	public int numberOfBeautifulIntegers(int low, int high, int k) {

		int count = 0;
		for(int i=low;i<=high;i++){
			if( i %k == 0 && countEqualDigits(i)){
				count++;
			}
		}
		return count;

	}

	private boolean countEqualDigits(int num) {

		String str = Integer.toString(num);
		int n = str.length();
		int even=0;
		int odd=0;
		for(int i=0;i<n;i++) {
			char ch = str.charAt(i);
			int x = Character.getNumericValue(ch);
			if( x % 2 == 0 )even++;
			else	odd++;

		}
		return even == odd;

	}

	public static boolean isArrayListSorted(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) < list.get(i)) {
				return false;
			}
		}
		return true;
	}
	public static int minOp(int idx, ArrayList<Integer> nums,int[] dp) {


		if( idx == nums.size()) {
			if( isArrayListSorted(nums) )	return 0;
			else
				return 10000000;
		}
		
		if(dp[idx] != -1)	return dp[idx];

		int dontChange = minOp(idx+1,nums,dp);
		
		int orig = nums.get(idx);

		int ch1 = Integer.MAX_VALUE;
		if( nums.get(idx) == 1 ) {
			ch1 = minOp(idx+1,nums,dp);
		}else {
			nums.set(idx,1);
			ch1 = 1 + minOp(idx+1,nums,dp);
			nums.set(idx, orig);

		}

		int ch2 = Integer.MAX_VALUE;
		if( nums.get(idx) == 2 ) {
			ch2 = minOp(idx+1,nums,dp);
		}else {
			nums.set(idx,2);
			ch2 = 1 + minOp(idx+1,nums,dp);
			nums.set(idx, orig);
		}
		
		int ch3 = Integer.MAX_VALUE;
		if( nums.get(idx) == 3 ) {
			ch3 = minOp(idx+1,nums,dp);
		}else {
			nums.set(idx,3);
			ch3 = 1 + minOp(idx+1,nums,dp);
			nums.set(idx, orig);
		}
		

//		return Math.min(Math.min(ch1, dontChange), Math.min(ch2, ch3));
		dp[idx] = Math.min(Math.min(ch1, dontChange), Math.min(ch2, ch3));
		return dp[idx];
	}

	public static int minimumOperations(List<Integer> nums) {
		ArrayList<Integer> numList = new ArrayList<Integer>(nums);
		int[] dp = new int[nums.size()];
		Arrays.fill(dp, -1);
		return minOp(0,numList,dp);

	}
	

	public static void main(String[] args) {
		System.out.println(minimumOperations(List.of(2,2,2,2,3,3)));
		System.out.println(minimumOperations(List.of(1,3,2)));
		System.out.println(minimumOperations(List.of(1,3,2,1,3,3)));
		System.out.println(minimumOperations(List.of(2,1,3,2,1)));
		System.out.println(minimumOperations(List.of(1,1,3,1,1,3,3,2)));
	}

}
