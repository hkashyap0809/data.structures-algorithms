package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;

public class SurroundedRegions {
	public static boolean isValid(int i, int j, int n, int m){
		return (i>=0 && i<=n-1 && j>=0 && j<=m-1);
	}
	public static void doDFS(int i, int j, char[][] board, boolean[][] visited ){
		int n = board.length;
		int m = board[0].length;
		visited[i][j] = true;

		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

		for( int[] direction : directions ){
			int nR = i + direction[0];
			int nC = j + direction[1];

			if( isValid(nR,nC,n,m) && board[nR][nC] == 'O' && !visited[nR][nC] ){
				doDFS(nR,nC,board,visited);
			}
		}
	}
	public void solve(char[][] board) {

		int n = board.length;
		int m = board[0].length;

		boolean[][] visited = new boolean[n][m];
		for( boolean[] row : visited )  Arrays.fill(row,false);


		for( int i = 0; i < n; i++ ){
			if( board[i][0] == 'O' && !visited[i][0] )  doDFS(i,0,board,visited);
			if( board[i][m-1] == 'O' && !visited[i][m-1])   doDFS(i,m-1,board,visited);
		}

		for( int j = 0; j < m; j++ ){
			if( board[0][j] == 'O' && !visited[0][j] )  doDFS(0,j,board,visited);
			if( board[n-1][j] == 'O' && !visited[n-1][j])   doDFS(n-1,j,board,visited);
		}

		for( int i =0 ; i<n;i++){
			for( int j=0; j<m;j++){
				if( !visited[i][j] && board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}
	}

}
