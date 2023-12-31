package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

class NearPair{
	int row;
	int col;
	int dis;
	NearPair(int row, int col, int dis){
		this.row = row;
		this.col = col;
		this.dis = dis;
	}
}
public class DistanceToNearest1 {

	public int[][] nearest(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;
		
		boolean[][] visited = new boolean[row][col];
		int[][] dist = new int[row][col];
		
		Queue<NearPair> queue = new LinkedList<NearPair>();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if ( grid[i][j] == 1 ) {
					queue.add(new NearPair(i, j,0));
					visited[i][j]=true;
				}
			}
		}
		
		while( !queue.isEmpty() ) {
		    
			NearPair topEl = queue.poll();
			int i = topEl.row;
			int j = topEl.col;
			int d = topEl.dis;
			dist[i][j] = d;
			
			int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			for( int[] direction : directions ) {
				int newRow = direction[0] + i;
				int newCol = direction[1] + j;
				if ( newRow < 0 || newCol < 0 || newRow > row-1 || newCol > col-1 )	continue;
				
				if ( !visited[newRow][newCol] && grid[newRow][newCol] == 0 ) {
					queue.add(new NearPair(newRow, newCol, 1+d));
					visited[newRow][newCol]=true;
				}
				
			}
		}
		return dist;
	}

}
