package com.datastructures.dp;

import java.util.Arrays;

public class NumberOfSubsets {
	//Recursion
	public static int findWaysRec(int idx, int[] num, int tar) {

		if ( tar == 0)  return 1;
		if( idx == 0 ) {
			if ( tar == num[idx] )
				return 1;
			else
				return 0;
		}

		int notTake = findWaysRec(idx-1,num,tar);
		int take = 0;
		if( num[idx] <= tar )
			take = findWaysRec(idx-1, num, tar - num[idx]);

		return take + notTake;
	}
	public static int findWaysRec(int num[], int tar) {
		return findWaysRec(num.length-1,num,tar);
	}
	//Memoization
	public static int findWaysMem(int idx, int[] num, int tar, int[][] dp) {

		if ( idx == 0){
			if ( tar == 0 && num[0] == 0 ) return 2;
			if ( tar == 0 || tar == num[idx]) return 1;
			return 0;
		}


		if ( dp[idx][tar] != -1) return dp[idx][tar];

		int notTake = findWaysMem(idx-1,num,tar,dp);
		int take = 0;
		if( num[idx] <= tar )
			take = findWaysMem(idx-1, num, tar - num[idx],dp);

		dp[idx][tar] = take + notTake;

		return take + notTake;
	}
	public static int findWaysMem(int num[], int tar) {
		int[][] dp =new int [num.length][tar+1];
		for(int i = 0;i <dp.length;i++)
			Arrays.fill(dp[i], -1);
		return findWaysMem(num.length-1,num,tar,dp);
	}
	//Tabulation
	public static int findWaysTab(int num[], int target) {
		int[][] dp = new int[num.length][target+1];

		if( num[0]==0 )	dp[0][0] = 2;
		else dp[0][0] = 1;

		if( num[0] != 0 && num[0] <= target ) dp[0][num[0]] = 1;


		for( int idx = 1; idx<num.length; idx++) {

			for(int tar = 0; tar <=target; tar++) {

				int notTake = dp[idx-1][tar];
				int take = 0;
				if( num[idx] <= tar )
					take = dp[idx-1][tar - num[idx]];

				dp[idx][tar] = take + notTake;
			}
		}

		return dp[num.length-1][target];
	}
	//Space Optimzation
	public static int findWays(int num[], int target) {
		int[] prevDp = new int[target+1];

		if( num[0]==0 )prevDp[0] = 2;
		else prevDp[0] = 1;

		if( num[0] != 0 && num[0] <= target ) prevDp[num[0]] = 1;

		for( int idx = 1; idx<num.length; idx++) {
			int[]  currDp = new int[target+1];

			for(int tar = 0; tar <=target; tar++) {

				int notTake = prevDp[tar];
				int take = 0;
				if( num[idx] <= tar )
					take = prevDp[tar - num[idx]];

				currDp[tar] = take + notTake;
			}
			prevDp = currDp;
		}
		return prevDp[target];
	}
}
