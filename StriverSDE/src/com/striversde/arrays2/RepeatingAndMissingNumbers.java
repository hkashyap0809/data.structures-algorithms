package com.striversde.arrays2;

import java.util.ArrayList;

public class RepeatingAndMissingNumbers {
	public static int[] missingAndRepeatingMath(ArrayList<Integer> arr, int n) {

		long sumN = (n*(n+1))/2;
		long sumNSq = (n*(n+1)*(2*n+1))/6;
		long sum=0;
		long sumSq=0;
		for( Integer num : arr) {
			sum+=num;
			sumSq = sumSq + (num*num);
		}

		long diff1 = sum - sumN;
		long diff2 = sumSq - sumNSq;

		long diff3 = diff2 / diff1;

		long rep = (diff1 + diff3)/2;
		long mis = rep - diff1;
		int[] res ={(int)mis,(int)rep};
		return res;

	}
	public static int[] missingAndRepeatingXOR(ArrayList<Integer> arr, int n) {

		int inputXOR = 0;
		int k = 1;
		for( Integer num : arr ) {
			inputXOR = inputXOR ^ num;
			inputXOR = inputXOR ^ k;
			k++;
		}

		int diffBit = 0;
		for( int i=0; i<32;i++) {
			int res = (inputXOR & (1<<i));
			// System.out.println(res);
			if ( res != 0 ) {
				diffBit = i;
				break;
			}
		}

		diffBit = (inputXOR & ~(inputXOR-1));

		int zeroBit = 0;
		int oneBit = 0;
		for ( Integer num : arr ) {
			if ( (num&diffBit) == 0 ) {
				zeroBit = zeroBit^num;
			}else {
				oneBit = oneBit^num;
			}
		}
		
		for(int i=1;i<=n;i++) {

			if ( (i&diffBit) == 0 ) {
				zeroBit = zeroBit^i;
			}else {
				oneBit = oneBit^i;
			}
		}


		int count = 0;
		for( Integer num : arr ) {
			if ( num == zeroBit) {
				count++;
			}
		}
		int repeat = 0;
		int missing = 0;
		if ( count == 2 ) {
			repeat = zeroBit;
			missing = oneBit;
		}else {
			repeat = oneBit;
			missing = zeroBit;
		}

		int[] ans = {missing,repeat};
		return ans;


	}
}
