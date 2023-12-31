package com.datastructures.test;

import java.util.Arrays;

public class MicrosoftMoves {
	public int recursion(int[] A, long sum,int[][] dp) {
		//		return recursionHelper(0,A.length-1, A, sum ,dp);
		return recursionTabulation(A, sum);
	}
	private int recursionHelper(int i, int j, int[] A, long sum,int[][] dp) {
		if( j - i + 1 == 2) {
			if( A[i]+A[j] == sum )	return 1;
			return 0;
		}
		if( j-i +1 < 2) return 0;

		if( dp[i][j] != -1) return dp[i][j];

		int move1 = 0;
		int move2 = 0;
		int move3 = 0;
		if( A[i] + A[i+1] == sum ) {
			move1 = 1 + recursionHelper(i+2,j,A,sum,dp);
		}
		if(A[i] + A[j] == sum ) {
			move2 = 1 + recursionHelper(i+1,j-1,A,sum,dp);
		}
		if( A[j] + A[j-1] == sum ) {
			move3 = 1 + recursionHelper(i,j-2,A,sum,dp);
		}
		return Math.max(move1, Math.max(move2, move3));

	}

	public int solution(int[] A) {
		int N = A.length;
		if( N < 2 ) return 0;
		long sum1 = A[0]+A[1];
		long sum2 = A[N-1]+A[N-2];
		long sum3 = A[0]+A[N-1];

		int[][] dp = new int[N][N];

		for(int i = 0;i < dp.length; i++){
			Arrays.fill(dp[i],-1);
		}

		int move1 = recursion(A,sum1,dp);

		for(int i = 0;i < dp.length; i++){
			Arrays.fill(dp[i],-1);
		}
		int move2 = recursion(A,sum2,dp);
		for(int i = 0;i < dp.length; i++){
			Arrays.fill(dp[i],-1);
		}
		int move3 = recursion(A,sum3,dp);

		return Math.max(move1,Math.max(move2,move3));
	}

	public int recursionTabulation( int[] A , long sum){
		int N = A.length;

		int[][] dp = new int[N][N];


		for( int i = N-1; i>=0; i--) {
			for( int j = 0; j<N; j++) {
				if( j-i +1 < 2) continue;

				int move1 = 0;
				int move2 = 0;
				int move3 = 0;
				if( A[i] + A[i+1] == sum ) {
					move1 = 1 + recursionHelper(i+2,j,A,sum,dp);
				}
				if(A[i] + A[j] == sum ) {
					move2 = 1 + recursionHelper(i+1,j-1,A,sum,dp);
				}
				if( A[j] + A[j-1] == sum ) {
					move3 = 1 + recursionHelper(i,j-2,A,sum,dp);
				}
				dp[i][j] =  Math.max(move1, Math.max(move2, move3));

			}
		}
		return dp[0][N-1];

	}
	public static void main(String[] args) {
		MicrosoftMoves m = new MicrosoftMoves();
		int[] A = {3,1,5,3,3,4,2};
		
//		int[] A = {4,1,4,3,3,2,5,2};
		
//		int[] A = {1,9,1,1,1,1,1,1,8,1};
//		int[] A = {1,9,8,9,5,1,2};
//		
//		int[] A = {1,1,2,3,1,2,2,1,1,2};
		
		
		m.solution(A);
		System.out.println(m.solution(A));
	}

}
