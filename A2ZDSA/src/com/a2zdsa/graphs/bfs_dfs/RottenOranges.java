package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	static class OrangeTuple{
		int row;
		int col;
		int time;
		OrangeTuple(int row, int col, int time){
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public boolean isValid(int i, int j, int m, int n){
		return ( i >=0 && i<= m-1 && j >=0 && j <= n-1);
	}
	public int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int freshOranges = 0;

		Queue<OrangeTuple> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		for( boolean[] row : visited ){
			Arrays.fill(row,false);
		}

		for( int i =0; i<m; i++){
			for( int j = 0; j< n; j++){
				if( grid[i][j] == 2 ){
					queue.add( new OrangeTuple(i,j,0));
					visited[i][j] = true;
				}else if( grid[i][j] == 1 ){
					freshOranges++;
				}
			}
		}
		int minTime = 0;
		int orangesRotten = 0;
		while( !queue.isEmpty() ){
			OrangeTuple top = queue.poll();
			int row = top.row;
			int col = top.col;
			int time = top.time;
			minTime = Math.max(minTime,time);

			int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

			for( int[] direction : directions ){
				int newRow = row + direction[0];
				int newCol = col + direction[1];

				//valid cell and a fresh Orange exists
				if( isValid(newRow, newCol,m,n) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                    orangesRotten++;
					queue.add( new OrangeTuple(newRow,newCol,time+1));
					visited[newRow][newCol] = true;
				}
			}

		}

		if( orangesRotten == freshOranges ) return minTime;
		return -1;
	}

}
