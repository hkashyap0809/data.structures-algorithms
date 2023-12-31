package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfIslands2 {
	public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
		DisjointSet disjointSet = new DisjointSet(rows*cols);

		List<Integer> result = new ArrayList<>();
		boolean[][] visited = new boolean[rows][cols];

		int islands = 0;
		int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

		for(int[] operator : operators ) {


			int row = operator[0];
			int col = operator[1];

			if ( visited[row][col] ) {

				result.add(islands);
				continue;
			}

			visited[row][col] = true;

			int node = row * cols + col ;

			islands++;

			for( int[] direction : directions ) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				if ( newRow < 0 || newCol < 0 || newRow > rows - 1 || newCol > cols - 1 )	continue;

				int newNode = newRow * cols + newCol;
				if ( visited[newRow][newCol] && disjointSet.findParent(newNode) != disjointSet.findParent(node) ) {
					disjointSet.unionByRank(newNode, node);
					islands--;
				}
			}
			result.add(islands);

		}

		return result;
	}

}
