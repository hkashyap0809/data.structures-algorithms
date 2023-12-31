package com.datastructures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple{
	public int distance;
	public int row;
	public int col;
	Tuple(int distance, int row, int col){
		this.distance = distance;
		this.row = row;
		this.col = col;
	}
}
public class ShortestPathBinaryMatrix1 {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if ( grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1)   return -1;
		if ( grid.length==1 && grid[0][0]==0 )    return 1;

		Queue<Tuple> queue = new LinkedList<>();
		int[][] distance = new int[grid.length][grid[0].length];

		for(int i=0;i<distance.length; i++){
			Arrays.fill(distance[i],10000);
		}

		distance[0][0] = 0;
		queue.add(new Tuple(1,0,0));

		int[] dRow = {-1,-1,0,1,1,1,0,-1};
		int[] dCol = {0,1,1,1,0,-1,-1,-1};

		while(!queue.isEmpty()){

			Tuple elem = queue.poll();
			int dist = elem.distance;
			int row = elem.row;
			int col = elem.col;


			for(int i=0;i<8;i++){
				int newRow = row + dRow[i];
				int newCol = col + dCol[i];

				if(newRow>=0 && newRow<=grid.length-1 && newCol>=0 && newCol<=grid[0].length-1 && grid[newRow][newCol]==0 && 1 + dist < distance[newRow][newCol]){
					distance[newRow][newCol] = 1 + dist;
					if(newRow == grid.length-1 && newCol == grid[0].length-1)   return 1+dist;
					queue.add(new Tuple(1+dist,newRow,newCol));
				}
			}
		}
		return -1;
	}
}
