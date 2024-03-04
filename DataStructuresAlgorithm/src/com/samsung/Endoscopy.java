package com.samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Endoscopy {
	static class Tuple{
		int x;
		int y;
		int length;
		Tuple( int x, int y, int length ){
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	private static boolean isValid(int i, int j, int n, int m) {
		return ( i>=0 && i<=n-1 && j>=0 && j<= m-1);
	}
	private static int bfs(int[][] grid, int endoX, int endoY, int endoL) {
		if( grid[endoX][endoY] == 0 )	return -1;

		int n = grid.length;
		int m = grid[0].length;
		int ans = 1;
		Queue<Tuple> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for( boolean[] row : visited ) {
			Arrays.fill(row, false);
		}
		queue.add( new Tuple( endoX, endoY,1));
		visited[endoX][endoY] = true;


		while( !queue.isEmpty() ) {
			Tuple topEl = queue.poll();
			int x = topEl.x;
			int y = topEl.y;
			int len = topEl.length;


			int nR = x - 1;
			int nC = y;
			//going up
			if( isValid(nR,nC,n,m) && !visited[nR][nC] && len+1 <= endoL) {

				//currently I am on pipe which goes up
				if(  grid[x][y] == 1 || grid[x][y] == 2 || grid[x][y] == 4 || grid[x][y] == 1 ) {
					//i am going to the pipe which has entry from down
					if( grid[nR][nC] == 1 || grid[nR][nC] == 2 || grid[nR][nC] == 5 || grid[nR][nC] == 6 ) {

						visited[nR][nC] = true;
						queue.add( new Tuple(nR,nC,len+1));
						ans++;
					}
				}

			}

			nR = x + 1;
			nC = y;
			//going down
			if( isValid(nR,nC,n,m) && !visited[nR][nC] && len+1 <= endoL) {
				if( grid[x][y] == 1 || grid[x][y] == 2 || grid[x][y] == 5 || grid[x][y] == 6 ) {
					if( grid[nR][nC] == 1 || grid[nR][nC] == 2 || grid[nR][nC] == 4 || grid[nR][nC] == 7) {
						visited[nR][nC] = true;
						queue.add( new Tuple(nR,nC,len+1));
						ans++;
					}
				}
			}

			nR = x;
			nC = y-1;
			//going left
			if( isValid(nR,nC,n,m) && !visited[nR][nC] && len+1 <= endoL) {
				if( grid[x][y] == 1 || grid[x][y] == 3 || grid[x][y] == 6 || grid[x][y] == 7 ) {
					if( grid[nR][nC] == 1 || grid[nR][nC] == 3 || grid[nR][nC] == 4 || grid[nR][nC] == 5) {
						visited[nR][nC] = true;
						queue.add( new Tuple(nR,nC,len+1));
						ans++;
					}
				}
			}


			nR = x;
			nC = y+1;
			//going right
			if( isValid(nR,nC,n,m) && !visited[nR][nC] && len+1 <= endoL) {
				if( grid[x][y] == 1 || grid[x][y] == 3 || grid[x][y] == 4 || grid[x][y] == 5 ) {
					if( grid[nR][nC] == 1 || grid[nR][nC] == 3 || grid[nR][nC] == 6 || grid[nR][nC] == 7) {
						visited[nR][nC] = true;
						queue.add( new Tuple(nR,nC,len+1));
						ans++;
					}
				}
			}

		}
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while( testCases-- > 0 ){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int l = sc.nextInt();

			int[][] grid = new int[n][m];
			for( int i =0;i <n;i++){
				for( int j =0; j<m;j++){
					grid[i][j] = sc.nextInt();
				}
			}

			int res = bfs(grid,r,c,l);
			System.out.println(res);
		}

	}

}


