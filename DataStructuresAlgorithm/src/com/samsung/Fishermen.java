package com.samsung;

import java.util.Scanner;

public class Fishermen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for( int t = 1; t<=T; t++ ) {
			int N = sc.nextInt();
			int[] menPos = new int[4];
			int[] menNum = new int[4];
			for( int i = 1; i<= 3; i++ ) {
				menPos[i] = sc.nextInt();
				menNum[i] = sc.nextInt();
			}
			int[] arr = new int[N];
			int[] ans = new int[1];
			ans[0] = Integer.MAX_VALUE;
			solve(1,2,3,1,0,ans,menPos,menNum, N,arr);
			solve(1,3,2,1,0,ans,menPos,menNum, N,arr);
			solve(2,1,3,2,0,ans,menPos,menNum, N,arr);
			solve(2,3,1,2,0,ans,menPos,menNum, N,arr);
			solve(3,1,2,3,0,ans,menPos,menNum, N,arr);
			solve(3,2,1,3,0,ans, menPos,menNum, N,arr);
			
			System.out.println(ans[0]);
		}
		
	}

	private static void solve(int g1, int g2, int g3, int curr, int cost, int[] ans, int[] menPos, int[] menNum, int N, int[] arr) {
		
		if( cost > ans[0] )	return;
		
		if( menNum[curr] == 0 ) {
			if( curr == g1 )	curr = g2;
			else if( curr == g2)curr = g3;
			else {
				ans[0] = Math.min(ans[0], cost);
				return;
			}
		}
		
		int left = posLeft(menPos[curr], arr);
		int costLeft = Math.abs(menPos[curr] - left + 1);
		int right = posRight(menPos[curr],arr);
		int costRight = Math.abs(menPos[curr] - right + 1);
		
		int dist = costLeft > costRight ? right : left;
		int temp = Math.min(costLeft, costRight);
		
		if(menNum[curr] == 1 && costLeft == costRight){
	           
	           arr[left] = 1;
	           menNum[curr]--;
	           solve(g1, g2, g3, curr, cost + costLeft,ans,menPos,menNum,N,arr);
	           arr[left] = 0;
	          menNum[curr]++;
	           
	           arr[right] = 1;
	           menNum[curr]--;
	           solve(g1, g2, g3, curr, cost + costRight,ans,menPos,menNum,N,arr);
	           arr[right] = 0;
	           menNum[curr]++;
	       }
	       
	   /* optimization is done here we are choosing the pos which is near*/
	    else{
	       arr[dist] = 1;
	       menNum[curr]--;
	       solve(g1,g2,g3,curr, cost + temp,ans,menPos,menNum,N,arr);
	       arr[dist] = 0;
	       menNum[curr]++;
	    }
		
		
	}

	private static int posRight(int idx, int[] arr) {
		for( int i = idx ; i<= arr.length; i++) {
			if( arr[i]== 0 )	return i;
		}
		return Integer.MAX_VALUE;
	}

	private static int posLeft(int idx, int[] arr) {
		for( int i = idx-1; i >0 ; i--) {
			if( arr[i] == 0 )	return i;

		}
		return Integer.MAX_VALUE;
	}

}
