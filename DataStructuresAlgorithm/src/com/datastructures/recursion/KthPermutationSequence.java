package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
	//Iterative
	public static String getPermutationLoop(int n, int k) {
		k=k-1;
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Integer> factorials = new ArrayList<>();
		nums.add(0);
		factorials.add(1);

		int prod = 1;
		for(int i=1;i<=n;i++){
			nums.add(i);
			prod = prod*i;
			factorials.add(prod);
		}

		String result = "";


		int newK = k;
		int newN = n;
		int i=0;

		while(newN != 1 ) {

			int blockNo = newK / factorials.get(newN-1);
			result=result+String.valueOf(nums.get(blockNo+1));

			newK = newK % factorials.get(newN-1);
			newN = newN-1;

			nums.remove(blockNo+1);

			factorials.remove(factorials.size()-1);
		}
		result = result + String.valueOf(nums.get(1));


		return result;
	}

	//Recursive
	public static String getKPermutation(String result, int n, int k, List<Integer> factorials,List<Integer> numbers ) {

		if(k == 0) {
			for(int i=1;i<numbers.size();i++) {
				result = result +Integer.toString(numbers.get(i));
			}
			return result;
		}

		int range = k / factorials.get(n-1);
		int perm = k % factorials.get(n-1);
		result=result + Integer.toString(numbers.get(range+1));
		numbers.remove(range+1);


		return getKPermutation(result, n-1, perm, factorials,numbers);


	}


	public static String getPermutationRecursive(int n, int k) {
		List<Integer> factorials = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();

		int fact = 1;
		numbers.add(0);
		factorials.add(1);
		for(int i=1;i<=n;i++) {
			fact = fact*i;
			factorials.add(fact);
			numbers.add(i);

		}

		String result ="";
		return getKPermutation(result,n, k-1, factorials,numbers);


	}

}
