//package com.cses.dynamicprogramming;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MinimizingCoins {
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;

		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException  e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public long nextLong()
		{
			return Long.parseLong(next());
		}

		public double nextDouble()
		{
			return Double.parseDouble(next());
		}

		public String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}
	
	
	public static void main(String args[]) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int k = fr.nextInt();
		int[] coins = new int[n];
		for( int i=0; i<n; i++) {
			coins[i] = fr.nextInt();
		}
		
		int[][] dp = new int[n][k+1];
		
		for( int target = 0; target<=k; target++) {
			if ( target % coins[0] == 0 ) {
				dp[0][target] = target / coins[0];
			}else {
				dp[0][target] = 10000000;
			}
			
		}
		
		for( int idx = 1; idx < n; idx++ ) {
			for( int target = 0; target <= k; target ++) {
				int notTake = dp[idx-1][target];
				int take = 10000000;
				if( coins[idx] <= target ) {
					take = 1 + dp[idx][target-coins[idx]];
					dp[idx][target] =  Math.min(take, notTake);
				}
			}
		}
		if( dp[n-1][k]== 10000000)	dp[n-1][k]=-1;
		System.out.println(dp[n-1][k]);
	}
}
