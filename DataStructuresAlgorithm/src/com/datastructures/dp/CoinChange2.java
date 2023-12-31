package com.datastructures.dp;

import java.util.Arrays;

public class CoinChange2 {

	//	rec
	public static long countWaysToMakeChangeRec(int idx, int denominations[], int value) {

		if(idx==0) {
			if(value%denominations[idx]==0)
				return 1;
			else
				return 0;
		}

		long notTake = countWaysToMakeChangeRec(idx-1, denominations, value);
		long take = 0;

		if(denominations[idx] <= value)
			take = countWaysToMakeChangeRec(idx, denominations, value-denominations[idx]);

		return take + notTake;


	}
	public static long countWaysToMakeChangeRec(int denominations[], int value){
		return countWaysToMakeChangeRec(denominations.length-1,denominations,value);	
	}

	//	mem
	public static long countWaysToMakeChangeMem(int idx, int denominations[], int value,long[][] dp) {

		if(idx==0) {
			if(value%denominations[idx]==0)
				return 1;
			else
				return 0;
		}

		if(dp[idx][value] != -1)return dp[idx][value];

		long notTake = countWaysToMakeChangeMem(idx-1, denominations, value,dp);
		long take = 0;

		if(denominations[idx] <= value)
			take = countWaysToMakeChangeMem(idx, denominations, value-denominations[idx],dp);

		dp[idx][value] = take + notTake;
		return dp[idx][value];


	}
	public static long countWaysToMakeChangeMem(int denominations[], int value){
		long[][] dp = new long[denominations.length][value+1];
		for(int i =0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return countWaysToMakeChangeMem(denominations.length-1,denominations,value,dp);	
	}

	//	tabulation
	public static long countWaysToMakeChange(int denominations[], int value){
		long[][] dp = new long[denominations.length][value+1];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],0);

		for(int val = 0; val <=value; val++) {
			if(val % denominations[0] == 0)
				dp[0][val] = 1;
		}

		for(int idx = 1; idx<denominations.length; idx++) {
			for(int val = 0; val <=value; val++) {

				long notTake = dp[idx-1][val];
				long take = 0;

				if(denominations[idx] <= val)
					take = dp[idx][val-denominations[idx]];

				dp[idx][val] = take + notTake;
			}
		}

		return dp[denominations.length-1][value];

	}


}
