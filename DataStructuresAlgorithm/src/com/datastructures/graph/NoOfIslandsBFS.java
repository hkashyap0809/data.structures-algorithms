package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
	public Integer first;
	public Integer second;
	
	Pair(Integer first, Integer second){
		this.first = first;
		this.second = second;
	}
}

public class NoOfIslandsBFS {
	
	public static void startBFS(int i, int j, boolean[][] visited,char[][] grid) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i,j));
		
		visited[i][j]=true;
		
		int[] dRow = {-1,-1,0,1,1,1,0,-1};
		int[] dCol = {0,1,1,1,0,-1,-1,-1};
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			for(int x=0; x<8;x++) {
				int newRow = pair.first + dRow[x];
				int newCol = pair.second + dCol[x];
				if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length)   continue;
				if(!visited[newRow][newCol] && grid[newRow][newCol]=='1') {
					queue.add(new Pair(newRow, newCol));
					visited[newRow][newCol]=true;
				}
			}
			
		}
		
	}
	public static int numIslands(char[][] grid) {
		int islands = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		
		for(int i = 0; i<grid.length;i++) {
			for(int j=0; j<grid[0].length;j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					startBFS(i,j,visited,grid);
					islands++;
				}
			}
		}
		return islands;
	}
}
