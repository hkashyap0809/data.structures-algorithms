package com.a2zdsa.dynamicProgramming.grids;

import java.util.Arrays;

public class NinjaTraining {
	public static int ninjaTrainingHelper(int dayIdx, int actIdx, int[][] points, int[][] dp){
		if( dayIdx == 0 ){
			int point = 0;
			for(int i = 0; i < 3; i++ ){
				if( i!=actIdx ){
					point = Math.max(point,points[0][i]);
				}
			}
			return point;
		}

		if( dp[dayIdx][actIdx] != -1 )	return dp[dayIdx][actIdx];

		int maxPoints = 0;
		for( int i =0; i< 3; i++ ){
			int pointsI = 0;
			if( i != actIdx ){
				pointsI = points[dayIdx][i] + ninjaTrainingHelper(dayIdx-1,i,points,dp);
			}
			maxPoints = Math.max( maxPoints, pointsI);
		}
		dp[dayIdx][actIdx] = maxPoints;
		return maxPoints;

	}
	public static int ninjaTrainingMEM(int n, int points[][]) {
		int[][] dp = new int[n][4];
		for( int[] row : dp ){
			Arrays.fill(row,-1);
		}
		return ninjaTrainingHelper(n-1,3,points,dp);
	}
	//TABULATION
	public static int ninjaTraining(int n, int points[][]) {

		int[][] dp = new int[n][4];
		dp[0][0] = Math.max(points[0][1],points[0][2]);
		dp[0][1] = Math.max(points[0][0],points[0][2]);;
		dp[0][2] = Math.max(points[0][0],points[0][1]);;
		dp[0][3] = Math.max(points[0][1],Math.max(points[0][0],points[0][2]));


		for( int dayIdx = 1; dayIdx < n; dayIdx++ ){
			for( int actIdx = 0; actIdx <=3; actIdx++ ){
				int maxPoints = 0;
				for( int i =0; i< 3; i++ ){
					int pointsI = 0;
					if( i != actIdx ){
						pointsI = points[dayIdx][i] + dp[dayIdx-1][i];
					}
					maxPoints = Math.max( maxPoints, pointsI);
				}
				dp[dayIdx][actIdx] = maxPoints;
			}
		}

		return dp[n-1][3];
	}

}
