package com.datastructures.graph;


public class FloodFillDFS {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor){

		int[][] result = new int[image.length][image[0].length];
		for(int i=0;i<result.length;i++){
			result[i] = image[i].clone();
		}


		boolean[][] visited = new boolean[image.length][image[0].length];

		startDFS(sr,sc,newColor,image,result,visited);

		return result;

	}

	private void startDFS(int sr, int sc, int newColor, int[][] image, int[][] result, boolean[][] visited) {
		visited[sr][sc] = true;
		result[sr][sc] = newColor;

		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};

		for(int k = 0; k<4; k++) {

			int newRow = sr + dr[k];
			int newCol = sc + dc[k];
			if ( newRow<0 || newCol<0 || newRow >= image.length || newCol >= image[0].length )	continue;

			if ( image[newRow][newCol] == image[sr][sc] && !visited[newRow][newCol]) {
				startDFS(newRow,newCol,newColor,image,result,visited);

			}

		}
	}

}

