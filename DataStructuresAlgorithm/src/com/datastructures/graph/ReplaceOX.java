package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ReplaceOX {
	//DFS SOLUTION
	private static void startDFS(int i, int j, boolean[][] visited, int n, int m,char[][] a) {
		visited[i][j]=true;

		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		for( int[] direction : directions ) {
			int newRow = i + direction[0];
			int newCol = j + direction[1];

			if ( newRow < 0 || newCol < 0 || newRow > n-1 || newCol > m-1) continue;
			if ( !visited[newRow][newCol] && a[newRow][newCol]=='O') {
				startDFS(newRow,newCol,visited,n,m,a);
				visited[newRow][newCol] = true;
			}
		}

	}


	public static char[][] fillDFS(int n, int m, char a[][]){
		boolean[][] visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			if (a[i][0] == 'O') {
				startDFS(i,0,visited,n,m,a);

			}
			if (a[i][m-1]=='O') {
				startDFS(i,m-1,visited,n,m,a);

			}
		}

		for(int j=0;j<m;j++) {
			if( a[0][j] == 'O') {
				startDFS(0, j, visited,n,m,a);

			}
			if ( a[n-1][j] == 'O' ) {
				startDFS(n-1, j, visited,n,m,a);

			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0; j<m;j++) {
				if ( !visited[i][j] && a[i][j]=='O') {
					a[i][j]='X';
				}
			}
		}

		return a;
	}

	//BFS SOLUTION

	public static char[][] fillBFS(int n, int m, char a[][]){

		boolean[][] visited = new boolean[n][m];
		Queue<Pair> queue = new LinkedList<Pair>();

		for(int i=0;i<n;i++) {
			if (a[i][0] == 'O') {
				queue.add(new Pair(i,0));
				visited[i][0]=true;
			}
			if (a[i][m-1]=='O') {
				queue.add(new Pair(i, m-1));
				visited[i][m-1]=true;
			}
		}

		for(int j=0;j<m;j++) {
			if( a[0][j] == 'O') {
				queue.add( new Pair(0,j));
				visited[0][j]=true;
			}
			if ( a[n-1][j] == 'O' ) {
				queue.add(new Pair(n-1, j));
				visited[n-1][j]=true;
			}
		}


		while( !queue.isEmpty() ) {
			Pair topEl = queue.poll();
			int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			for( int[] direction : directions ) {
				int newRow = topEl.first + direction[0];
				int newCol = topEl.second + direction[1];

				if ( newRow < 0 || newCol < 0 || newRow > n-1 || newCol > m-1) continue;
				if ( !visited[newRow][newCol] && a[newRow][newCol]=='O') {
					queue.add( new Pair(newRow,newCol));
					visited[newRow][newCol] = true;
				}
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0; j<m;j++) {
				if ( !visited[i][j] && a[i][j]=='O') {
					a[i][j]='X';
				}
			}
		}

		return a;
	}


}
