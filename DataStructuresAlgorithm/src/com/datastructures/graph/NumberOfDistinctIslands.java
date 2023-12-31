package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;



public class NumberOfDistinctIslands {

	//BFS Solution
	int countDistinctIslands(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		boolean[][] visited = new boolean[row][col];
		HashSet<ArrayList<String>> hashSet = new HashSet<>();

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ArrayList<String> islandShape = new ArrayList<String>();
				if ( !visited[i][j] && grid[i][j]==1) {
					startBFS(i,j,visited,grid,row,col,islandShape,i,j);
					hashSet.add(islandShape);
				}
			}
		}
		return hashSet.size();

	}

	private void startBFS(int i, int j, boolean[][] visited, int[][] grid, int row, int col,
			ArrayList<String> islandShape, int baseI, int baseJ) {

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(i,j));
		visited[i][j] = true;

		while( !queue.isEmpty() ) {

			Pair topEl = queue.poll();

			int topI = topEl.first;
			int topJ = topEl.second;
			islandShape.add(getStringEquivalent(topI - baseI, topJ - baseJ));

			int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			for(int[] direction : directions) {
				int newRow = topI + direction[0];
				int newCol = topJ + direction[1];

				if ( newRow < 0|| newCol < 0 || newRow > row - 1 || newCol > col-1 )	continue;
				if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
					queue.add(new Pair(newRow,newCol));
					visited[newRow][newCol] = true;
				}
			}
		}
	}

	//DFS Solution
	int countDistinctIslandsDFS(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		boolean[][] visited = new boolean[row][col];
		HashSet<ArrayList<String>> hashSet = new HashSet<>();

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ArrayList<String> islandShape = new ArrayList<String>();
				if ( !visited[i][j] && grid[i][j]==1) {
					startDFS(i,j,visited,grid,row,col,islandShape,i,j);
					hashSet.add(islandShape);
				}
			}
		}
		return hashSet.size();
	}
	public String getStringEquivalent(int row, int col) {
		return Integer.toString(row)+"-"+Integer.toString(col);
	}
	private void startDFS(int i, int j, boolean[][] visited, int[][] grid, int row, int col,ArrayList<String> islandShape, int baseI, int baseJ) {
		visited[i][j] = true;
		islandShape.add(getStringEquivalent(i-baseI, j-baseJ));

		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int[] direction : directions) {
			int newRow = i + direction[0];
			int newCol = j + direction[1];

			if ( newRow < 0|| newCol < 0 || newRow > row - 1 || newCol > col-1 )	continue;
			if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
				startDFS(newRow,newCol,visited,grid,row,col,islandShape,baseI,baseJ);
			}
		}

	}

}
