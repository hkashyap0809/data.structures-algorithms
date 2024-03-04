package com.samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChessPiece {
	
	static class Tuple{
		int row;
		int col;
		int level;
		Tuple(int row, int col, int level){
			this.row = row;
			this.col = col;
			this.level = level;
		}
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int i = 1;
		while( i <= T ) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int rM = sc.nextInt();
			int cM = sc.nextInt();
			
			int rS = sc.nextInt();
			int cS = sc.nextInt();
			
			int res = findMinMoves(N,M,rM,cM,rS,cS);
			System.out.println("Test Case "+i);
			System.out.println("Moves "+res);
			i++;
		}
	}

	private static int findMinMoves(int n, int m, int rM, int cM, int rS, int cS) {
		Queue<Tuple> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n+1][m+1];
		for( boolean[] row : visited )	Arrays.fill(row,  false);
		
		queue.add( new Tuple( rM, cM, 0));
		visited[rM][cM] = false;
		
		int[][] directions = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
		
		while( !queue.isEmpty() ) {
			
			Tuple topEl = queue.poll();
			int row = topEl.row;
			int col = topEl.col;
			int level = topEl.level;
			for( int[] direction : directions ) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				
				if( isValid(n,m,newRow,newCol) && !visited[newRow][newCol]) {
					
					if( newRow == rS && newCol == cS ) {
						return level+1;
					}
					queue.add(new Tuple( newRow, newCol,level+1));
					visited[newRow][newCol] = true;
				}
			}
		}
		return -1;
		
	}

	private static boolean isValid(int n, int m, int i, int j) {
		return ( i>=0 && i<= n-1 && j >= 0 && j<= m-1);
	}

}
