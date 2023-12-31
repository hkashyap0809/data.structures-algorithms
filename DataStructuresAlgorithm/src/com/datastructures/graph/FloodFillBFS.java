package com.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;


class MyPair{
	int first;
	int second;
	MyPair(int first,int second){
		this.first = first;
		this.second = second;
	}
}

public class FloodFillBFS {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor){

		int[][] result = new int[image.length][image[0].length];
		for(int i=0;i<result.length;i++){
			result[i] = image[i].clone();
		}
		boolean[][] visited = new boolean[image.length][image[0].length];

		startBFS(sr,sc,newColor,image,result,visited);

		return result;

	}

	private void startBFS(int sr, int sc, int newColor, int[][] image, int[][] result, boolean[][] visited) {
		Queue<MyPair> queue = new LinkedList<>();

		queue.add(new MyPair(sr, sc));
		visited[sr][sc] = true;
		result[sr][sc] = newColor;

		while( !queue.isEmpty() ) {
			MyPair topEl = queue.poll();
			int row = topEl.first;
			int col = topEl.second;

			int[] dr = {-1,0,1,0};
			int[] dc = {0,1,0,-1};

			for(int k = 0; k<4; k++) {
				int newRow = row + dr[k];
				int newCol = col + dc[k];
				if ( newRow<0 || newCol<0 || newRow >= image.length || newCol >= image[0].length )	continue;
				if ( image[newRow][newCol] == image[row][col] && !visited[newRow][newCol]) {
					result[newRow][newCol] = newColor;
					visited[newRow][newCol] = true;
					queue.add(new MyPair(newRow,newCol));
				}

			}
		}

	}

	//Optimal - without extra space
	public int[][] floodFillOptimal(int[][] image, int sr, int sc, int newColor){

		boolean[][] visited = new boolean[image.length][image[0].length];
		int initialColor = image[sr][sc];

		startBFSOptimal(sr,sc,newColor,image,initialColor,visited);

		return image;

	}

	private void startBFSOptimal(int sr, int sc, int newColor, int[][] image, int initialColor, boolean[][] visited) {
		Queue<MyPair> queue = new LinkedList<>();

		queue.add(new MyPair(sr, sc));
		visited[sr][sc] = true;
		image[sr][sc] = newColor;

		while( !queue.isEmpty() ) {
			MyPair topEl = queue.poll();
			int row = topEl.first;
			int col = topEl.second;

			int[] dr = {-1,0,1,0};
			int[] dc = {0,1,0,-1};

			for(int k = 0; k<4; k++) {
				int newRow = row + dr[k];
				int newCol = col + dc[k];
				if ( newRow<0 || newCol<0 || newRow >= image.length || newCol >= image[0].length )	continue;
				if ( image[newRow][newCol] == initialColor && !visited[newRow][newCol]) {
					image[newRow][newCol] = newColor;
					visited[newRow][newCol] = true;
					queue.add(new MyPair(newRow,newCol));
				}

			}
		}

	}

}
