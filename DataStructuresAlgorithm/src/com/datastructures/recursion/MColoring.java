package com.datastructures.recursion;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class MColoring {
	public boolean isColoringPossible(int nodeIdx, int col, int[] color, boolean[][] graph) {
		for(int i=0;i<graph.length;i++) {
			if(i!=nodeIdx && graph[nodeIdx][i] && color[i]==col)
				return false;
		}
		return true;
	}
	public  boolean colorGraph(int nodeIdx, boolean graph[][], int m, int n, int[] color) {
		if(nodeIdx == n) {
			return true;
		}
		for(int col=1 ;col<=m; col++){
			if (isColoringPossible(nodeIdx,col,color,graph)) {
				color[nodeIdx] = col;
				if(colorGraph(nodeIdx+1,graph,m,n,color)==true) return true;
				color[nodeIdx]=0;
			}
		}
		return false;
	}
	public  boolean graphColoring(boolean graph[][], int m, int n) {
	    
		int[] color = new int[n];
		Arrays.fill(color,0);
		if(colorGraph(0,graph,m,n,color)==true) return true;
		return false;
		
	}
}
