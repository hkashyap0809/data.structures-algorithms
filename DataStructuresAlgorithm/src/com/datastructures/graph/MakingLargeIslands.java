package com.datastructures.graph;

import java.util.HashSet;

public class MakingLargeIslands {
	public int getNode(int i, int j, int col) {
		return i*col + j;
	}
	public int MaxConnection(int grid[][]) {
		int row = grid.length;
		int col = grid[0].length;

		DisjointSet disjointSet = new DisjointSet(row*col);


		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
		int res = 0; 

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( grid[i][j] == 1 ) {

					int node = getNode(i,j,col);

					for(int[] direction : directions ) {
						int newRow = i + direction[0];
						int newCol = j + direction[1];

						if ( newRow < 0 || newCol < 0 || newRow > row - 1 || newCol > col - 1)	continue;
						if( grid[newRow][newCol] == 0 ) continue;

						int newNode = getNode(newRow, newCol, col);

						if( disjointSet.findParent(node) != disjointSet.findParent(newNode) ) {
							disjointSet.unionBySize(node, newNode);
						}
					}
					res = Math.max(res, disjointSet.size[disjointSet.findParent(node)]);
				}

			}
		}

		for(int i=0; i<row; i++) {
			for(int j=0;j<col;j++) {
				if ( grid[i][j] == 0 ) {
					HashSet<Integer> parentsSet = new HashSet<>();

					for(int[] direction : directions ) {
						int newRow = i + direction[0];
						int newCol = j + direction[1];

						if ( newRow < 0 || newCol < 0 || newRow > row - 1 || newCol > col - 1)	continue;
						if( grid[newRow][newCol] == 0 )	continue;

						int newNode = getNode(newRow, newCol, col);
						parentsSet.add(disjointSet.findParent(newNode));
					}

					int size = 1;
					for( Integer parent : parentsSet ) {
						size = size + disjointSet.size[disjointSet.findParent(parent)];
					}
					res = Math.max(res, size);
				}
			}
		}

		return res;
	}
}
