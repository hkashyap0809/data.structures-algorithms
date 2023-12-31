package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

class OrangesTuple{
	int row;
	int col;
	int time;
	OrangesTuple(int row, int col, int time) {
		this.row = row;
		this.col=col;
		this.time = time;
	}
}
public class RottenOranges {
	public int orangesRotting(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		int[][] visited = new int[row][col];

		int countFresh = 0;

		Queue<OrangesTuple> queue = new LinkedList<>();

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if ( grid[i][j] == 2 ) {
					queue.add(new OrangesTuple(i, j, 0));
					visited[i][j] = 2;
				}else if( grid[i][j] == 1 ) {
					countFresh++;
				}
			}
		}

		int minTime = 0;
		while( !queue.isEmpty() ) {

			OrangesTuple topEl = queue.poll();
			int i = topEl.row;
			int j = topEl.col;
			int t = topEl.time;
			minTime = t;

			int[] dRow = {-1,0,1,0};
			int[] dCol = {0,1,0,-1};

			for(int k = 0 ; k<4; k++) {
				int newRow = i + dRow[k];
				int newCol = j + dCol[k];
				if ( newRow<0 || newCol<0 || newRow>=row || newCol>=col) continue;
				if ( visited[newRow][newCol]!=2 && grid[newRow][newCol] == 1 ) {
					queue.add(new OrangesTuple(newRow, newCol, t+1));
					visited[newRow][newCol]=2;
					countFresh--;
				}

			}
		}

		if ( countFresh == 0 )
			return minTime;
		else
			return -1;



	}

}
