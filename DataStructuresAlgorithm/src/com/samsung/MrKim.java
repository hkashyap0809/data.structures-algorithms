package com.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MrKim {


	public static void main(String[] args) {



		Scanner sc = new Scanner(System.in);
		String res = "";

		for( int a = 0; a<10; a++) {

			int[] pointsX = new int[12];
			int[] pointsY = new int[12];


			int N = sc.nextInt();

			int officeX = sc.nextInt();
			int officeY = sc.nextInt();

			int homeX = sc.nextInt();
			int homeY = sc.nextInt();


			pointsX[0] = officeX;
			pointsY[0] = officeY;


			for( int i =1 ;i <= N; i++ ) {
				int custX = sc.nextInt();
				int custY = sc.nextInt();
				pointsX[i] = custX;
				pointsY[i] = custY;
			}

			pointsX[N+1] = homeX;
			pointsY[N+1] = homeY;


			//number of customer
			int mask = (1 << (N+1)) - 1;
			int[][] dp = new int[12][1 << 11];

			for( int[] row : dp )	Arrays.fill(row, -1);

			res =res + Integer.toString( findMinDist(N+1,mask,pointsX,pointsY, dp, N) ) +" \n";
			//			
		}
		System.out.println(res);

	}

	private static int findMinDist(int p,int mask, int[] pointsX, int[] pointsY, int[][] dp, int N) {
		if ( p == 0 && mask == 0 )	return 0;
		else if( p == 0 )	return 1000000;

		dp[p][mask] = 1000000;

		for( int  i = N; i >= 0 ; i-- ) {
			if( (mask & (1 << i)) != 0  ) {
				int dist = Math.abs(pointsX[i] - pointsX[p]) + Math.abs(pointsY[i] - pointsY[p]);
				dp[p][mask] = Math.min( dp[p][mask], findMinDist( i , mask ^ (1<<i), pointsX, pointsY, dp, N)+ dist);
			}
		}
		return dp[p][mask];
	}




}
