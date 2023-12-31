package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {
	
	//DFS Solution
	public void startDFS(int i, int j, boolean[][] visited, int[][] grid,int row, int col) {
		visited[i][j] = true;
		
		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		
		for( int[] direction : directions ) {
			int newRow = i + direction[0];
			int newCol = j + direction[1];
			
			if ( newRow < 0 || newCol < 0 || newRow > row-1 || newCol > col-1) continue;
			if ( !visited[newRow][newCol] && grid[newRow][newCol]==1) {
				startDFS(newRow,newCol,visited,grid,row,col);
			}
		}
	}
	int numberOfEnclaves(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		
		for(int i=0; i<row;i++) {
			if( grid[i][0]==1) {
				startDFS(i,0,visited,grid,row,col);
			}
			if (grid[i][col-1]==1) {
				startDFS(i,col-1,visited,grid,row,col);
			}
		}
		
		for(int j=0; j<col;j++) {
			if ( grid[0][j] == 1) {
				startDFS(0,j,visited,grid,row,col);
			}
			if ( grid[row-1][j]==1) {
				startDFS(row-1,j,visited,grid,row,col);
			}
		}
		
		int count=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if ( !visited[i][j] && grid[i][j]==1) {
					count++;
				}
			}
		}
		return count;
	
	}
	
	//BFS Solution
	int numberOfEnclavesBFS(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		Queue<MyPair> queue = new LinkedList<MyPair>();
		boolean[][] visited = new boolean[row][col];
		
		for(int i=0; i<row;i++) {
			if( grid[i][0]==1) {
				queue.add(new MyPair(i, 0));
				visited[i][0] = true;
			}
			if (grid[i][col-1]==1) {
				queue.add(new MyPair(i, col-1));
				visited[i][col-1] = true;
			}
		}
		
		for(int j=0; j<col;j++) {
			if ( grid[0][j] == 1) {
				queue.add(new MyPair(0, j));
				visited[0][j] = true;
			}
			if ( grid[row-1][j]==1) {
				queue.add(new MyPair(row-1,j));
				visited[row-1][j] = true;
			}
		}
		
		while( !queue.isEmpty() ) {
			MyPair topEl = queue.poll();
			int i = topEl.first;
			int j = topEl.second;
			
			int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			
			for( int[] direction : directions ) {
				int newRow = i + direction[0];
				int newCol = j + direction[1];
				
				if ( newRow < 0 || newCol < 0 || newRow > row-1 || newCol > col-1) continue;
				if ( !visited[newRow][newCol] && grid[newRow][newCol]==1) {
					queue.add(new MyPair(newRow, newCol));
					visited[newRow][newCol]=true;
				}
			}
			
		}
		
		int count=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if ( !visited[i][j] && grid[i][j]==1) {
					count++;
				}
			}
		}
		return count;
	}
}
