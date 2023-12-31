package com.striversde.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {
	private static boolean isValid(int newRow, int newCol, int n){
		return ( newRow>=0 && newRow<=n-1 && newCol>=0 && newCol<=n-1 );
	}
	private static void getAllPaths(int i, int j, int[][] grid, int n, ArrayList<String> result, String path,boolean[][] visited) {

		if ( i == n-1 && j == n-1 ) {
			result.add(path);
			return;
		}

		int[] dRow = {1,0,0,-1};
		int[] dCol = {0,-1,1,0};

		for (int k =0; k<4; k++) {

			int newRow = i + dRow[k];
			int newCol = j + dCol[k];
			if ( isValid(newRow,newCol,n) && !visited[newRow][newCol] && grid[newRow][newCol]==1 )  {

				visited[i][j] = true;
				getAllPaths(newRow, newCol, grid, n, result, path + "DLRU".charAt(k), visited);
				visited[i][j] = false;
			}
		}

	}
	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> result= new ArrayList<>();
		String path = "";
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<visited.length;i++)
			Arrays.fill(visited[i],false);

		if ( m[0][0] == 1 )
			getAllPaths(0,0,m,n,result,path,visited);
		return result;

	}
}