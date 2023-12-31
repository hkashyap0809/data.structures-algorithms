package com.striversde.arrays4;

import java.util.HashMap;

public class CountSubarraysXorK {
	public static int subarraysWithXORK(int []a, int b) {
		HashMap<Integer,Integer> prefixXORMap = new HashMap<>();


		int n = a.length;
		int count = 0;
		int XOR = 0;
		prefixXORMap.put(0,1);

		for( int i = 0;i < n; i++ ){

			XOR = XOR ^ a[i];

			Integer diffXOR = (XOR ^ b);
			if ( prefixXORMap.containsKey(diffXOR) ){
				count = count + prefixXORMap.get(diffXOR);
			}
			prefixXORMap.put(XOR,prefixXORMap.getOrDefault(XOR,0)+1);


		}
		return count;
	}

}
