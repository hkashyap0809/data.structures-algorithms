package com.striversde.arrays3;

public class SearchIn2DMatrix {

	
	public boolean searchMatrixBinary(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int low = 0;
		int high = row * col - 1; 
		
		while(low <= high ) {
			int mid = (low + high )/2;
			if ( matrix[mid/col][mid%col] == target ) {
				return true;
			}else if ( matrix[mid/col][mid%col] > target ) {
				high = mid-1;
			}else {
				low=mid + 1;
			}
		}
		return false;
	}
	//Optimal
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0;
		int j = matrix[0].length -1 ;
		while( i <= matrix.length-1 && j>=0 ){
			if ( matrix[i][j] == target )   return true;
			else if( matrix[i][j] > target ){
				j--;
			}else{
				i++;
			}
		}
		return false;
	}
}
