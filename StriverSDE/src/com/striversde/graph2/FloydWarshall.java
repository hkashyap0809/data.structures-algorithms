package com.striversde.graph2;

public class FloydWarshall {
	public static void shortest_distance(int[][] matrix){
		int n = matrix.length;


		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if ( matrix[i][j] == -1 ) {
					matrix[i][j] = 1000000;
				}
				if ( i == j )	matrix[i][j] = 0;
			}
		}

		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = Math.min(matrix[i][j],  matrix[i][k] + matrix[k][j]);
				}
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if ( matrix[i][j] >= 10000 ) {
					matrix[i][j] = -1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] mat = { { 0, 5, 9, 100 }, { 100, 0, 2, 8 }, { 100, 100, 0, 7 }, { 4, 100, 100, 0 } };
		 shortest_distance(mat);
		
		for( int[] row : mat ) {
			for( int val : row ) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
}
