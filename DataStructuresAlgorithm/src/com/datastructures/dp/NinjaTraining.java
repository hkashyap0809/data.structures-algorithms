package com.datastructures.dp;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
public class NinjaTraining {

	//Recursion
	private static int ninjaTrainingRec(int day, int lastTask, int[][] points) {
		if ( day == 0 ) {
			int pts = 0;
			for(int i=0; i<3;i++) {
				if ( i != lastTask )
					pts = Math.max(pts, points[0][i]);
			}
			return pts;
		}

		int maxPts = 0;

		for(int i = 0; i<3;i++) {
			int pts = 0;
			if ( i != lastTask) {
				pts = points[day][i] + ninjaTrainingRec(day-1, i, points);
			}
			maxPts = Math.max(maxPts, pts);
		}
		return maxPts;
	}
	public static int ninjaTrainingRec(int n, int points[][]) {
		return ninjaTrainingRec(n-1,3,points);

	}
	//Memoization
	private static int ninjaTrainingMem(int day, int lastTask, int[][] points,int[][] dp) {
		if ( day == 0 ) {
			int pts = 0;
			for(int i=0; i<3;i++) {
				if ( i != lastTask )
					pts = Math.max(pts, points[0][i]);
			}
			return pts;
		}
		if ( dp[day][lastTask] != -1 )	return dp[day][lastTask];

		int maxPts = 0;

		for(int i = 0; i<3;i++) {
			int pts = 0;
			if ( i != lastTask) {
				pts = points[day][i] + ninjaTrainingMem(day-1, i, points,dp);
			}
			maxPts = Math.max(maxPts, pts);
		}
		dp[day][lastTask] = maxPts;
		return maxPts;
	}
	public static int ninjaTrainingMem(int n, int points[][]) {
		int[][] dp = new int[n][4];
		for ( int i=0;i<n;i++)
			Arrays.fill(dp[i], -1);
		return ninjaTrainingMem(n-1,3,points,dp);

	}
	//Tabulation
	public static int ninjaTrainingTab(int n, int points[][]) {
		int[][] dp = new int[n][4];

		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][1], points[0][0]);
		dp[0][3] = Math.max(points[0][0],Math.max( points[0][2],points[0][1]));

		for ( int day = 1; day<n; day++) {
			for( int lastTask = 0; lastTask<=3; lastTask++) {
				int maxPts = Integer.MIN_VALUE;
				for(int i = 0; i<3;i++) {
					int pts = 0;
					if ( i != lastTask) {
						pts = points[day][i] + dp[day-1][i];
					}
					maxPts = Math.max(maxPts, pts);
				}
				dp[day][lastTask] = maxPts;
			}

		}
		return dp[n-1][3];
	}
	//Space Optimization
	public static int ninjaTraining(int n, int points[][]) {
		int[] dp = new int[4];

		dp[0] = Math.max(points[0][1], points[0][2]);
		dp[1] = Math.max(points[0][0], points[0][2]);
		dp[2] = Math.max(points[0][1], points[0][0]);
		dp[3] = Math.max(points[0][0],Math.max( points[0][2],points[0][1]));

		for ( int day = 1; day<n; day++) {
			int[] currDp = new int[4];
			for( int lastTask = 0; lastTask<=3; lastTask++) {
				int maxPts = Integer.MIN_VALUE;
				for(int i = 0; i<3;i++) {
					int pts = 0;
					if ( i != lastTask) {
						pts = points[day][i] + dp[i];
					}
					maxPts = Math.max(maxPts, pts);
				}
				currDp[lastTask] = maxPts;
			}
			dp = currDp;

		}
		return dp[3];
	}

}