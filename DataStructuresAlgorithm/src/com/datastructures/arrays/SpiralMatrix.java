package com.datastructures.arrays;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{9 ,8, 2, 5, -1, -1, -5, 7 ,1, 2, -2},
				{			1, 8, -7, 1, 9, 7 ,-5 ,3 ,-2 ,-3, 1},
				{				-3, 7, 2, -7, -3, -9, 6, 0, 8, 0, 4},
				{				6, 0, 0, 6, -3, 9, -4, 6 ,6, 1, 4},
				{			-6, -7, 8, 9, -3, -9, 4, 7, 3, 1, -4}};

		printSpiralRecursive(matrix);
		printSpiralIterative(matrix);
	}



	private static void printSpiralIterative(int[][] matrix) {
		int rowStart = 0;
		int rowEnd = matrix.length-1;
		int colStart = 0;
		int colEnd = matrix[0].length-1;

		ArrayList<Integer> ds = new ArrayList<>();

		while( rowStart <= rowEnd && colStart <= colEnd ) {

			for( int j = colStart; j<= colEnd; j++) {
				ds.add(matrix[rowStart][j]);

			}

			for(int i = rowStart+1; i<=rowEnd; i++) {
				ds.add(matrix[i][colEnd]);
			}

			if ( rowStart <= rowEnd ) {
				for(int j = colEnd-1; j>=colStart; j--) {
					ds.add(matrix[rowEnd][j]);
				}
			}


			if ( colStart <= colEnd ) {
				for(int i = rowEnd-1; i>=rowStart+1; i--) {
					ds.add(matrix[i][colStart]);
				}
			}

			rowStart = rowStart + 1;
			rowEnd = rowEnd - 1;
			colStart = colStart + 1;
			colEnd = colEnd - 1;
		}

		System.out.println(ds.toString());
	}





	//Recursive
	private static void printSpiralRecursive(int[][] matrix) {
		ArrayList<Integer> spiralMatrix = new ArrayList<>();
		printSpiralRecursive(matrix,0,matrix.length-1,0,matrix[0].length-1,spiralMatrix);
		System.out.println(spiralMatrix.toString());

	}

	private static void printSpiralRecursive(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd,ArrayList<Integer> ds) {
		if ( rowStart > rowEnd || colStart > colEnd ) return;

		for( int j = colStart; j<= colEnd; j++) {
			ds.add(matrix[rowStart][j]);
		}

		for(int i = rowStart+1; i<=rowEnd; i++) {
			ds.add(matrix[i][colEnd]);
		}

		if ( rowStart != rowEnd ) {
			for(int j = colEnd-1; j>=colStart; j--) 
				ds.add(matrix[rowEnd][j]);
		}


		if ( colStart != colEnd ) {
			for(int i = rowEnd-1; i>=rowStart+1; i--) 
				ds.add(matrix[i][colStart]);
		}


		printSpiralRecursive(matrix, rowStart+1, rowEnd-1, colStart+1, colEnd-1,ds);

	}

}
