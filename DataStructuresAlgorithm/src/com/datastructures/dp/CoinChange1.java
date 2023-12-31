package com.datastructures.dp;

import java.util.Arrays;

public class CoinChange1 {
//	rec
	public static int minimumElementsRec(int idx, int[] num, int target) {
		if(idx==0) {
			if(target%num[0]==0)	
				return target/num[0];
			else 
				return 100000;
		}
		
		int notTake = minimumElementsRec(idx-1, num, target);
		int take = 100000;
		if(num[idx] <= target)
			take = 1 + minimumElementsRec(idx, num,target - num[idx]);
		
		return Math.min(take, notTake);
	}
	public static int minimumElementsRec(int num[], int x) {
        return minimumElementsRec(num.length-1,num,x);
	}
//	mem
	
	public static int minimumElementsMem(int idx, int[] num, int target,int[][] dp) {
		if(idx==0) {
			if(target%num[0]==0)	
				return target/num[0];
			else 
				return 100000;
		}
		if(dp[idx][target] != -1)return dp[idx][target];
		
		int notTake = minimumElementsMem(idx-1, num, target,dp);
		int take = 100000;
		if(num[idx] <= target)
			take = 1 + minimumElementsMem(idx, num,target - num[idx],dp);
		
		dp[idx][target] = Math.min(take, notTake);
		return dp[idx][target];
	}
	public static int minimumElementsMem(int num[], int x) {
		int[][] dp =new int[num.length][x+1];
		for(int i=0;i<num.length;i++) {
			Arrays.fill(dp[i],-1);
		}
        int ans = minimumElementsMem(num.length-1,num,x,dp);
        return ans;
	}
	
//	tab
	public static int minimumElements(int num[], int x) {
		int[][] dp =new int[num.length][x+1];

		
		for(int j=0;j<=x;j++) {
			if(j%num[0]==0)
				dp[0][j] = j / num[0];
			else
				dp[0][j] = 1000000;
		}
		
		for(int idx = 1; idx<num.length;idx++) {
			for(int target = 0; target <=x; target++) {
				int notTake = dp[idx-1][target];
				int take = 1000000;
				if(num[idx] <= target)
					take = 1 + dp[idx][target - num[idx]];
				
				dp[idx][target] = Math.min(take, notTake);
			}
		}
		return dp[num.length-1][x];
	}

	
}
