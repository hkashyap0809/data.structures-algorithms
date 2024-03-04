package com.samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ResearchTeam {

	static class Node{
		int x;
		int y;
		int level;
		Node(int x, int y, int level){
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while( testCases-- > 0 ) {
			int n = sc.nextInt();
			int nRare = sc.nextInt();
			int[][] rareElem = new int[nRare][2];

			for( int i =0;i < nRare; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				rareElem[i][0] = x-1;
				rareElem[i][1] = y-1;


			}
			int[][] grid = new int[n][n];
			for( int i =0; i< n; i++ ) {
				for( int j =0; j<n;j++ ) {
					grid[i][j] = sc.nextInt();
				}
			}

			int ans = 1000000;
			boolean[][] visited = new boolean[100][100];

			for(int i =0; i<n; i++){
				for(int j =0; j<n; j++){
					int temp;
					if(grid[i][j] == 1){
						temp = 0;

						for(int k = 0; k<nRare; k++){
							for( boolean[] row : visited ) Arrays.fill(row, false);
							
							int res = bfs(i,j,rareElem[k][0],rareElem[k][1],grid,n, visited);
							temp = Math.max(res,temp);
						}
						ans = Math.min(ans,temp);
					}

				}
			}
			System.out.println(ans);

		}
	}

	private static int bfs(int i, int j, int rareX, int rareY, int[][] grid, int n, boolean[][] visited) {
		Queue<Node> queue = new LinkedList<>();
		queue.add( new Node (i,j,0));
		visited[i][j] = true;
		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!queue.isEmpty() ) {
			Node topEl = queue.poll();
			int x = topEl.x;
			int y = topEl.y;
			int level = topEl.level;
			if( topEl.x == rareX && topEl.y == rareY )	return topEl.level;
			
			for( int[] direction : directions ) {
				int nR = topEl.x + direction[0];
				int nC = topEl.y + direction[1];
				
				if( isValid(nR,nC,n) && grid[nR][nC] == 1 && !visited[nR][nC] ) {
					queue.add( new Node( nR, nC, level+1));
					visited[nR][nC] = true;
				}
			}
		}
		return 0;
	}

	private static boolean isValid(int nR, int nC, int n) {
		return ( nR>=0 && nR <= n-1 && nC>=0 && nC <= n-1);
	}

}
