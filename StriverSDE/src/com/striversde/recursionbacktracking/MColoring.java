package com.striversde.recursionbacktracking;

import java.util.Arrays;

public class MColoring {
	public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[graph.length];
		Arrays.fill(color,0);
		return graphColoring(0,graph,m,color);
    }
    public static boolean possibleToColor(int node, boolean[][] mat, int col, int[] color){
		for(int i=0; i<mat.length;i++){
			if ( mat[node][i] && color[i]==col )	return false;
		}
		return true;
	}
	public static boolean graphColoring(int node, boolean[][] mat, int m, int[] color){

		if ( node == mat.length ){
			return true;
		}

		for(int i = 1; i<=m; i++){
			if( possibleToColor(node,mat,i,color) ){
				color[node] = i;
				if ( graphColoring(node+1,mat,m,color) == true )
					return true;
				else
					color[node]=0;
			}
		}
		return false;
	}
}
