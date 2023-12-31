package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctNumberWindow {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		HashMap<Integer,Integer> hashMap = new HashMap<>();

		ArrayList<Integer> result = new ArrayList<>();

		int i = 0;
		int j = 0;
		int n = A.size();

		while ( j < n ) {
			hashMap.put(A.get(j), hashMap.getOrDefault(A.get(j), 0)+1);
			if( j - i + 1  == B) {
				result.add(hashMap.size());
				if( hashMap.get(A.get(i)) == 1 ) {
					hashMap.remove(A.get(i));
				}else {
					hashMap.put(A.get(i),hashMap.get(A.get(i))-1);
				}
				i++;
			}
			j++;
		}
		return result;
	}


}
class Solution {
	public long modPower(long x, long y, long p){
		long res = 1; 

		x = x % p;
		if (x == 0) return 0;
		while (y > 0){
			if ((y & 1) != 0)
				res = (res * x) % p;
			y = y >> 1; 
			x = (x * x) % p;
		}
		return res;
	}

	public long countHelper( int mask, int num, int[] bitmask, HashSet<Integer> repeatedFactors, HashMap<Integer,Integer> countMap, long MOD){
		if( num == 1 )  return 1;

		long notTake = countHelper(mask,num-1,bitmask,repeatedFactors,countMap,MOD);
		notTake = notTake % MOD;

		long take = 0;
		if( !repeatedFactors.contains(num) && ((mask | bitmask[num]) == mask) && countMap.get(num)!=null ){
			take = countHelper(mask ^ bitmask[num], num-1, bitmask, repeatedFactors,countMap,MOD) * countMap.get(num);
			take = take % MOD;
		}
		return (take + notTake) % MOD;
	}
	public int numberOfGoodSubsets(int[] nums) {
		int[] primes = {2,3,5,7,11,13,17,19,23,29};
		long MOD = 1000000007;

		HashSet<Integer> repeatedFactors = new HashSet<Integer>(Arrays.asList(4,8,9,12,16,18,20,24,25,27,28));
		HashMap<Integer, Integer> countMap = new HashMap<>();

		for(int num : nums){
			countMap.put(num,countMap.getOrDefault(num,0)+1);
		}

		int[] bitmask = new int[31];
		for(int num = 0; num <=30 ; num ++){
			for(int i = 0 ; i<primes.length;i++){
				if( num % primes[i] == 0 ){
					bitmask[num] = (bitmask[num] | (1<<i));
				}
			}
		}

		// for(int i=0;i<bitmask.length;i++){
		//     System.out.println(String.format("%2s",Integer.toString(i).replace(' ','0'))+"\t\t"+String.format("%10s", Integer.toBinaryString(bitmask[i])).replace(' ', '0'));
		// }
		long ans = countHelper(1023,30,bitmask, repeatedFactors, countMap, MOD)-1;
		if( countMap.get(1)!=null)  ans = ans * modPower(2,countMap.get(1),MOD);
		ans = ans % MOD;

		return (int)ans;

	}
}