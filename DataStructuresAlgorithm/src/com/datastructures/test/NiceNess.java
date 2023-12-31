package com.datastructures.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class NiceNess {

	public static int generatePatternAndCheck(int idx, int[] A, int[] B,int N, ArrayList<Integer> pattern, HashSet<Integer> hashSet) {


		for( int i = 0; i<N; i++) {

		}
	}
	
	public static int[] absDiff(int[] A) {
		int[] res = new int[A.length-1];
		for( int i =0; i < A.length -1 ; i++) {
			res[i] = A[i+1] - A[i]; 
		}
		return res;
	}

	public static int solution(int N, int[] A, int[] B) {

		ArrayList<Integer> pattern = new ArrayList<Integer>();
		for(int i = 1; i < N; i++) {
			if( A[i] > A[i-1] )pattern.add(1);
			else pattern.add(-1);
		}

		return 1;
	}
	public static void main(String[] args)throws IOException
	{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//
//		int R[] = new int[N];
//		int B[] = new int[N];
//		String[] strNums = new String[N];
//
//		strNums = br.readLine().split(" ");
//
//		for (int i = 0; i < N; i++) {
//			R[i] = Integer.parseInt(strNums[i]);
//		}
//
//		strNums = br.readLine().split(" ");
//
//		for (int i = 0; i < N; i++) {
//			B[i] = Integer.parseInt(strNums[i]);
//		}
			
//		solution(N, R, B);
		
		//abs diff
//		int[] a = {4,7,2,6};
//		int[] p = absDiff(a);
//		for(int i=0;i<p.length;i++) {
//			System.out.println(p[i]+" ");
//		}
	}
}
