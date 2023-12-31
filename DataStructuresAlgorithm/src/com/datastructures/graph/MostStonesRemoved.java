package com.datastructures.graph;

import java.util.HashSet;

public class MostStonesRemoved {
	int maxRemove(int[][] stones, int n) {
		
		int rows = 0;
		int cols = 0;
		for(int[] stone : stones ) {
			rows = Math.max(rows, stone[0]);
			cols = Math.max(cols, stone[1]);
		}
		
		DisjointSet disjointSet = new DisjointSet(rows+cols+1);
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for( int[] stone : stones ) {
			int stoneRow = stone[0];
			int stoneCol = stone[1] + rows + 1;
			disjointSet.unionByRank(stoneRow, stoneCol);
			hashSet.add(stoneRow);
			hashSet.add(stoneCol);
		}
		
		int components = 0;
		for( Integer num : hashSet ) {
			if( disjointSet.findParent(num) == num ) {
				components++;
			}
		}
		return n - components;
	}

}
