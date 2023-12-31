package com.datastructures.graph;


public class NoOfIslandsDFS {

	public static void startDFS(int i, int j, boolean[][] visited,char[][] grid) {

		visited[i][j]=true;

		int[] dRow = {-1,-1,0,1,1,1,0,-1};
		int[] dCol = {0,1,1,1,0,-1,-1,-1};


		for(int x=0; x<8;x++) {
			int newRow = i + dRow[x];
			int newCol = j + dCol[x];
			if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length)   continue;
			if(!visited[newRow][newCol] && grid[newRow][newCol]=='1') {
				startDFS(newRow,newCol,visited,grid);

			}
		}

	}

	public static int numIslands(char[][] grid) {
		int islands = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];


		for(int i = 0; i<grid.length;i++) {
			for(int j=0; j<grid[0].length;j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					startDFS(i,j,visited,grid);
					islands++;
				}
			}
		}
		return islands;
	}
}
