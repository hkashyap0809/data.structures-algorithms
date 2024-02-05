package com.cses.sortingandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
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
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		long sum = 0;
		long maxSum = Integer.MIN_VALUE;
		for( int i =0; i<n; i++) {
			long val = fr.nextLong();
			sum = sum + val;
			maxSum = Math.max(sum, maxSum);
			if( sum < 0 )	sum = 0;
		}
		System.out.println(maxSum);
	}

}
