package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	public int[][] updateMatrix(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		int[][] nearestDist = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		for( boolean[] row : visited )  Arrays.fill(row, false);

		Queue<int[]> queue = new LinkedList<>();
		for( int i = 0; i< m; i++){
			for( int j = 0; j <n; j++){
				if( mat[i][j] == 0 ){
					queue.add( new int[]{i,j,0});
					visited[i][j] = true;
				}
			}
		}

		while( !queue.isEmpty() ){
			int[] top = queue.poll();
			int i = top[0];
			int j = top[1];
			int d = top[2];
			nearestDist[i][j] = d;

			int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			for( int[] dir : directions ){
				int nR = i + dir[0];
				int nC = j + dir[1];

				if( nR >= 0 && nR <= m-1 && nC >= 0 && nC <= n-1 && mat[nR][nC] == 1 && !visited[nR][nC]){
					queue.add( new int[]{ nR,nC, 1+d});
					visited[nR][nC] = true;
				}
			}
		}
		return nearestDist;
	}

}
