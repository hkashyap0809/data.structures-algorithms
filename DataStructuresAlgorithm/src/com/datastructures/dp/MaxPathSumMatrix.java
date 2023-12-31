package com.datastructures.dp;
import java.util.*;

public class MaxPathSumMatrix {
	//Recursion
	public static int getMaxPathSumRec(int i, int j,int[][] matrix){
		if( j<0 || j>matrix[0].length-1)	return -1000000;
		if( i == 0 )	return matrix[0][j];


		int up = matrix[i][j] + getMaxPathSumRec(i-1,j,matrix);
		int upLeft = matrix[i][j] + getMaxPathSumRec(i-1,j-1,matrix);
		int upRight = matrix[i][j] + getMaxPathSumRec(i-1,j+1,matrix);
		return Math.max(up,Math.max(upLeft,upRight));
	}
	public static int getMaxPathSumRec(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		int maxPath = -100000;
		for(int i = 0; i<m;i++){
			maxPath = Math.max(maxPath,getMaxPathSumRec(n-1,i,matrix));
		}
		return maxPath;
	}

	//Memoization
	public static int getMaxPathSumMem(int i, int j,int[][] matrix,int[][] dp){
		if( j<0 || j>matrix[0].length-1)	return -1000000;
		if( i == 0 )	return matrix[0][j];
		if ( dp[i][j] != -1)	return dp[i][j];


		int up = matrix[i][j] + getMaxPathSumMem(i-1,j,matrix,dp);
		int upLeft = matrix[i][j] + getMaxPathSumMem(i-1,j-1,matrix,dp);
		int upRight = matrix[i][j] + getMaxPathSumMem(i-1,j+1,matrix,dp);
		dp[i][j] =  Math.max(up,Math.max(upLeft,upRight));
		return dp[i][j];
	}
	public static int getMaxPathSumMem(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		int maxPath = -100000;
		int[][] dp = new int[n][m];
		for(int i=0;i<n;i++)
			Arrays.fill(dp[i],-1);
		for(int i = 0; i<m;i++){
			maxPath = Math.max(maxPath,getMaxPathSumMem(n-1,i,matrix,dp));
		}
		return maxPath;
	}

	//Tabulation
	public static int getMaxPathSumTab(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] dp = new int[n][m];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],0);

		// base case
		for(int i=0;i<m;i++)
			dp[0][i] = matrix[0][i];

		for( int i=1 ;i <n; i++){
			for(int j = 0;j<m ;j++){

				int up = matrix[i][j] + dp[i-1][j];
				int upLeft = matrix[i][j];
				int upRight = matrix[i][j];
				if (j-1>=0)
					upLeft += dp[i-1][j-1];
				else
					upLeft += -100000000;
				if(j+1<=m-1)
					upRight += dp[i-1][j+1];
				else
					upRight += -100000000;

				dp[i][j] = Math.max(up,Math.max(upLeft,upRight));
			}
		}
		int maxPath = -100000000;
		for(int i=0;i<m;i++){
			maxPath = Math.max(maxPath,dp[n-1][i]);
		}

		return maxPath;
	}

	//Space optimization
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;

		int[] prevDp = new int[m];

		Arrays.fill(prevDp,0);

		// base case
		for(int i=0;i<m;i++)
			prevDp[i] = matrix[0][i];

		for( int i=1 ;i <n; i++){
			int[] currDp =new int[m];
			for(int j = 0;j<m ;j++){

				int up = matrix[i][j] + prevDp[j];
				int upLeft = matrix[i][j];
				int upRight = matrix[i][j];

				if (j-1>=0)
					upLeft += prevDp[j-1];
				else
					upLeft += -100000000;
				if(j+1<=m-1)
					upRight += prevDp[j+1];
				else
					upRight += -100000000;

				currDp[j] = Math.max(up,Math.max(upLeft,upRight));
			}
			prevDp = currDp;
		}
		int maxPath = -100000000;
		for(int i=0;i<m;i++){
			maxPath = Math.max(maxPath,prevDp[i]);
		}

		return maxPath;
	}
}
