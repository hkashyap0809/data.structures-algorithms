package com.striversde.arrays2;


public class RotateMatrix {
	//Brute
	public static void rotateBrute(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] ans = new int[row][col];

		for(int i=0; i<row; i++) {
			for(int j=0; j<col;j++) {
				ans[j][col-1-i] = matrix[i][j];
			}
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				matrix[i][j] = ans[i][j];
			}
		}
	}
	//Optimal
	private static void swap(int i, int j, int[][] matrix) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}

	private static void reverseArray(int[] row) {
		int i = 0;
		int j = row.length - 1;
		while ( i <= j ) {
			int temp = row[i];
			row[i] = row[j];
			row[j] = temp;
			i++;
			j--;
		}
	}
	private static void transposeMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i=0; i < row; i++) {
			for(int j = i+1; j< col; j++) {
				if ( i != j ) {
					swap(i,j,matrix);
				}
			}
		}
	}
	private static void reverseEachRow(int[][] matrix) {
		for ( int[] row : matrix ) {
			reverseArray(row);
		}
	}
	public void rotate(int[][] matrix) {
		transposeMatrix(matrix);
		reverseEachRow(matrix);
	}
}
