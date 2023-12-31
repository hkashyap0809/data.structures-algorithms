package com.a2zdsa.binarySearch.matrix;

public class PeakElement2 {

	public int[] findPeakGrid(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;

		int low  = 0;
		int high = cols-1;

		while( low <= high ) {
			int mid = (low+high)/2;

			int maxVal = Integer.MIN_VALUE;
			int maxIdxRow = -1;
			for( int i = 0;i < rows; i++ ) {
				if( mat[i][mid] > maxVal ) {
					maxVal = mat[i][mid];
					maxIdxRow = i;
				}
			}

			int i = maxIdxRow;
			int j = mid;

			int left = j-1 >=0 ? mat[i][j-1] : -1;
			int right = j+1 < cols ? mat[i][j+1] : -1;
			int up = i-1 >=0 ? mat[i-1][j] : -1;
			int down = i+1 < rows ? mat[i+1][j] : -1;


			if( mat[i][j] > left && mat[i][j] > right && mat[i][j] > up && mat[i][j] > down ) return new int[] {i,j};

			else if( left < mat[i][j] && mat[i][j] < right ) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}

		}
		return new int[] {-1,-1};

	}

}
