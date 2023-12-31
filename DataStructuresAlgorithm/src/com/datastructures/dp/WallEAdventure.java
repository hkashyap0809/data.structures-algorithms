package com.datastructures.dp;
import java.util.*;

public class WallEAdventure {

	public static boolean wallE(int i, int j, int[][] matrix,int charge){
		// if ( i <0 || j < 0 )   return false;

		if ( i == 0 && j== 0 && charge == 0) return true;
		// if ( i == 0 && j== 0 && charge != 0) return false;

		boolean moveleft = false;
		if ( j-1 >= 0 )
			moveleft = wallE(i,j-1,matrix,charge + matrix[i][j-1]);
		boolean moveUp = false;
		if(i-1>=0)
			moveUp = wallE(i-1,j,matrix,charge + matrix[i-1][j]);


		return moveleft | moveUp;


	}
	public static String wallE(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		if(wallE(row-1,col-1,matrix,matrix[row-1][col-1]))
			return "YES"; 
		else
			return "NO";
	}
	
	public static int wallEMem(int i, int j, int[][] matrix,int charge,int[][] dp){

		if ( i == 0 && j== 0 && charge == 0) return 1;
		if( dp[i][j] != -1) return dp[i][j];
		
		int moveleft = 0;
		if ( j-1 >= 0 )
			moveleft = wallEMem(i,j-1,matrix,charge + matrix[i][j-1],dp);
		
		int moveUp = 0;
		if(i-1>=0)
			moveUp = wallEMem(i-1,j,matrix,charge + matrix[i-1][j],dp);


		dp[i][j] = moveleft | moveUp;
		return dp[i][j];


	}
	public static String wallEMem(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp =new int[row][col];
		if(wallEMem(row-1,col-1,matrix,matrix[row-1][col-1],dp)==1)
			return "YES"; 
		else
			return "NO";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while( testCases > 0 ){
			testCases--;
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] mat = new int[row][col];
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					mat[i][j] = sc.nextInt();
				}
			}
			System.out.println(wallE(mat));
		}
	}
}
