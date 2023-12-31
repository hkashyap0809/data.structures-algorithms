package com.datastructures.test;

public class MicrosoftMinCostRehab {
	
	private static int solutionHelper(int idx, int[] A, int N, int X, int Y) {
		if( X < 0 )	return 10000000;
				
		if( idx == N-1 ) {
			if( X == 0 )	return 10000000;
			return A[idx];
			
		}
		
		if( idx >= N )	return 1000000;
		
		int notTake = solutionHelper( idx + 1, A, N, X, Y);
		
		int take = A[idx] + solutionHelper(idx+Y,A,N,X-1,Y);
		
		return Math.min( take, notTake );
		
	}
	static int solution(int[] A, int N, int X, int Y) {
		
		return solutionHelper(0,A,N,X,Y);
	}
	static int solutionBrute(int[] A, int N, int X, int Y) {
		
		int minCost = Integer.MAX_VALUE;
		
		for( int i = 0; i< N; i++ ) {
			boolean possible = true;
			int cost = 0;
			
			if( i + (X-1)*Y >= N )	break;
			
			for( int x = 0; x < X; x++ ) {
				int idx = i + x*Y;
				
				if( idx >= N ) {
					possible = false;
					break;
				}
				cost = cost + A[idx];
			}
			if( possible ) {
				minCost = Math.min(minCost, cost);
			}
		}
		return minCost;
	}
	public static void main(String[]args) {
//		int N = 4;
//		int[] A = {4,2,3,7};
//		int X = 2;
//		int Y = 2;
		//7
		
		
		int N = 4;
		int[] A = {10,3,4,7};
		int X = 2;
		int Y = 3;
		//17
		
		
		
//		int[] A = {4,2,5,4,3,5,1,4,2,7};
//		int N = A.length;
//		int X = 3;
//		int Y = 2;
		//6
		System.out.println(solutionBrute(A,N,X,Y));
	}

}
