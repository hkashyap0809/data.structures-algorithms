package com.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceshipExplosion {
	private static boolean isPrime(int a){
        int i = 2;
        int lim = (int)(Math.sqrt(a));
        while( i < lim ){
            if( a%i == 0 )  return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt(); 
        if( a > b )	System.out.println("Prvide valid input")
        for( int i = a; i <b; i++ ){
            if(isPrime(i))  System.out.print(i+" ");
        }
    }

//	public static void main(String[]args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		int[][] matrix = new int[n][5];
//		for( int i =0; i <n;i++) {
//			for( int j =0; j< 5;j++) {
//				matrix[i][j] = sc.nextInt();
//			}
//		}
//
//		int maxCoins = getMaxCoins(matrix, 1, n);
//		System.out.println(maxCoins);
//		
//		
//	}

	private static int getMaxCoins(int[][] matrix, int bombs, int n) {

		int[][][] dp = new int[n+1][5][2];
		for( int[][] mat : dp ) {
			for( int[] row : mat ) {
				Arrays.fill( row, -1);
			}
		}
		return getMaxCoins(n, 2, matrix, bombs, n, dp);
	}

	private static int getMaxCoins(int i, int j, int[][] matrix, int bombs, int n, int[][][] dp) {
		if( isNotValid(i,j,n) )	return 0;

		//dp
		
		if( dp[i][j][bombs] != -1 )	return dp[i][j][bombs];
		
		int ans = 0;

		if( i > 0 && matrix[i-1][j] != 2 ) {
			
			ans = Math.max( ans ,  (matrix[i-1][j] == 1 ? 1 : 0 ) + getMaxCoins(i-1, j, matrix, bombs, n,dp));
		}

		if( i > 0 && j > 0 && matrix[i-1][j-1] != 2 ) {
			ans = Math.max( ans ,  (matrix[i-1][j-1] == 1 ? 1 : 0 ) + getMaxCoins(i-1, j-1, matrix, bombs, n,dp));

		}

		if( i > 0 && j < 4 && matrix[i-1][j+1] != 2 ) {
			ans = Math.max( ans ,  (matrix[i-1][j+1] == 1 ? 1 : 0 ) + getMaxCoins(i-1, j+1, matrix, bombs, n,dp));
		}

		if( ans == 0 && bombs > 0 ) {
			//			detonate bomb
			updateMatrix(i-1,matrix);
			ans = getMaxCoins(i,j,matrix,bombs-1,n,dp);
		}
		return dp[i][j][bombs] = ans;
	}

	private static void updateMatrix(int row, int[][] matrix) {
		if( row < 0 )	return;
		for( int i = row; i >= Math.max( 0 , row-4 ) ; i-- ) {
			for( int j =0; j< 5; j++ ) {
				if( matrix[i][j] == 2 ) {
					matrix[i][j] = 0;
				}
			}
		}
		
	}

	private static boolean isNotValid( int i, int j, int n) {
		return ( i<= 0 || j < 0 || j >= 5 );
	}

}

/*

INP :
6
0 1 0 2 0
0 0 0 0 1
0 0 1 1 1
1 0 1 0 0
0 0 1 0 0
1 1 0 0 1

OUT : 5


6
0 1 0 2 0
0 2 2 2 1
0 2 1 1 1
1 0 1 0 0
0 0 1 2 2
2 2 2 2 2

*/
