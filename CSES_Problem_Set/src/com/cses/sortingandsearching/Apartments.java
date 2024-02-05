package com.cses.sortingandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Apartments {
	
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
		int m = fr.nextInt();
		long k = fr.nextLong();
		HashMap<Long,Long> hashMap = new HashMap<>();
		for( int i = 0; i<n; i++) {
			long req = fr.nextLong();
			hashMap.put(req+k, hashMap.getOrDefault(req+k, 0L)+1);
			hashMap.put(req-k, hashMap.getOrDefault(req-k, 0L)+1);
		}
		int count = 0;
		for( int i =0; i<m; i++) {
			long apt = fr.nextLong();
			
			hashMap.put(apt+k, hashMap.getOrDefault(apt+k, 0L)+1);
			hashMap.put(apt-k, hashMap.getOrDefault(apt-k, 0L)+1);
			
			if( hashMap.containsKey(apt)) {
				hashMap.put(apt, hashMap.get(apt)-1);
				count++;
				if( hashMap.get(apt) == 0 )	hashMap.remove(apt);
				
			}
		}
		System.out.println(count);
		
	}

}
