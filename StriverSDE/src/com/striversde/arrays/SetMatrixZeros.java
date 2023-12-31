package com.striversde.arrays;

public class SetMatrixZeros {
	//Better
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[] rowMap = new int[row];
		int[] colMap = new int[col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if ( matrix[i][j] == 0 ) {
					rowMap[i]=1;
					colMap[j]=1;
				}
			}
		}
		
		for(int i=0; i<rowMap.length; i++) {
			if(rowMap[i] == 1) {
				for( int j=0; j<col;j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j=0; j<colMap.length;j++) {
			if (colMap[j] == 1) {
				for(int i = 0 ;i<row;i++) {
					matrix[i][j]=0;
				}
			}
		}
	}
//	Optimal
	public static void setZeros(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int matrix00 = matrix[0][0];

		for(int i = 0; i<row;i++) {
			for(int j = 0; j<col; j++) {
				if(matrix[i][j] == 0) {
					if (j==0) {
						matrix[i][0] = 0;
						matrix00 = 0;
					}else {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}
		
		for(int i = row-1; i>=1;i--) {
			for(int j=col-1; j>=1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j]=0;
				}
			}
		}
		for(int j=col-1; j>=0; j--) {
			if ( matrix[0][0] == 0 )
				matrix[0][j]=0;
		}
		
		for(int i=row-1; i>=0; i--) {
			if( matrix00 == 0) {
				matrix[i][0] = 0;
			}
		}
		
	}
}
