package com.cses.dynamicprogramming;

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
		int target = fr.nextInt();
		int[] coins = new int[n];
		for( int i=0; i<n; i++) {
			coins[i] = fr.nextInt();
		}
		
		System.out.println(minCoins(coins,target));
	}


	private static long minCoins(int[] coins, int target) {
		int[][] dp = new int[coins.length][target+1];
		for( int[] row : dp ) {
			Arrays.fill(row, -1);
		}
		return minCoinsHelper(coins.length-1,coins,target,dp);
	}


	private static int minCoinsHelper(int idx, int[] coins, int target,int[][] dp) {
		if ( target == 0 ) return 0;
		if ( idx == 0 ) {
			if ( target % coins[idx] == 0 ) {
				return target / coins[idx];
			}
			return 100000000;
		}
		
		if( dp[idx][target] != -1 )	return dp[idx][target];	
		
		int notTake = minCoinsHelper(idx-1,coins,target,dp);
		int take = 100000000;
		if( coins[idx] <= target ) {
			take = 1 + minCoinsHelper(idx,coins,target-coins[idx],dp);
		}
		return Math.min(take, notTake);
	}
}
