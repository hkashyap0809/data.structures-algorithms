package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {
	
	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> result = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i], false);
		}
		String path = "";
		int[] dRow = {1,0,0,-1};
		int[] dCol = {0,-1,1,0};
		
		if(m[0][0]==1)
		    getAllPaths(0,0, m, n, result,path,visited,dRow,dCol);
		return result;
	}
	public static boolean isValid(int rowIdx, int colIdx, int n) {
		return (rowIdx>=0 && colIdx >=0 && rowIdx<=n-1 && colIdx<=n-1);
	}

	public static void getAllPaths(int rowIdx, int colIdx, int[][] m, int n, ArrayList<String> result,String path,boolean[][] visited, int[] dRow, int[] dCol) {
		
		if(rowIdx==n-1 && colIdx==n-1) {
			result.add(path);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int newRow = rowIdx + dRow[i];
			int newCol = colIdx + dCol[i];
			if(isValid(newRow,newCol,n) && !visited[newRow][newCol] && m[newRow][newCol]==1){
				visited[rowIdx][colIdx]=true;
				getAllPaths(newRow,newCol,m,n,result,path+"DLRU".charAt(i),visited,dRow,dCol);
				visited[rowIdx][colIdx]=false;
			}
		}		
	}

}
