package com.datastructures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortestPathBinaryMatrix2 {
	int shortestPath(int[][] grid, int[] source, int[] destination) {

		int srcRow = source[0];
		int srcCol = source[1];
		int destRow = destination[0];
		int destCol = destination[1];

		if (srcRow == destRow && srcCol == destCol) return 0;
		if ( grid[srcRow][srcCol] == 0 || grid[destRow][destCol] == 0)   return -1;

		if ( grid.length==1 && grid[srcRow][srcCol]==0 )    return 0;

		Queue<Tuple> queue = new LinkedList<>();
		int[][] distance = new int[grid.length][grid[0].length];

		for(int i=0;i<distance.length; i++){
			Arrays.fill(distance[i],10000);
		}

		distance[srcRow][srcCol] = 0;
		queue.add(new Tuple(0,srcRow,srcCol));

		int[] dRow = {-1,0,1,0};
		int[] dCol = {0,1,0,-1};

		while(!queue.isEmpty()){

			Tuple elem = queue.poll();
			int dist = elem.distance;
			int row = elem.row;
			int col = elem.col;


			for(int i=0;i<4;i++){
				int newRow = row + dRow[i];
				int newCol = col + dCol[i];

				if(newRow>=0 && newRow<=grid.length-1 && newCol>=0 && newCol<=grid[0].length-1 && grid[newRow][newCol]==1 && 1 + dist < distance[newRow][newCol]){
					distance[newRow][newCol] = 1 + dist;
					if(newRow == destRow && newCol == destCol)   return 1+dist;
					queue.add(new Tuple(1+dist,newRow,newCol));
				}
			}
		}
		return -1;
	}
}
