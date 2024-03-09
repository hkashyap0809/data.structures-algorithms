package com.a2zdsa.graphs.bfs_dfs;

public class NumberOfEnclaves {
	public static boolean isValid( int i, int j, int n, int m ){
		return (i>=0 && i<=n-1 && j>=0 && j<=m-1);
	}

	public static void doDFS( int i, int j, int[][] grid, boolean[][] visited){
		visited[i][j] = true;

		int n = grid.length;
		int m = grid[0].length;

		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
		for( int[] dir : directions ){
			int nR = i + dir[0];
			int nC = j + dir[1];

			if( isValid(nR,nC,n,m) && !visited[nR][nC] && grid[i][j] == 1 ) doDFS(nR,nC,grid,visited);
		}
	}
	public int numEnclaves(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;


		boolean[][] visited = new boolean[n][m];
		for( boolean[] row : visited )   Arrays.fill(row, false);

		int count = 0 ;

		for( int i = 0; i <n; i++ ){
			if( grid[i][0] == 1 && !visited[i][0] )  doDFS(i,0,grid,visited);
			if( grid[i][m-1] == 1 && !visited[i][m-1])  doDFS(i,m-1,grid,visited);
		}


		for( int j = 0; j<m;j++){
			if( grid[0][j] == 1 && !visited[0][j] ) doDFS(0,j,grid,visited);
			if( grid[n-1][j] == 1 && !visited[n-1][j] ) doDFS(n-1,j, grid,visited);
		}

		for( int i =0; i<n; i++ ){
			for( int j = 0; j < m; j++ ){
				if( !visited[i][j] && grid[i][j] == 1 ) count++;
			}
		}
		return count;

	}

}
