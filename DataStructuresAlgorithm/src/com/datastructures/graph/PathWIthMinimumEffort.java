package com.datastructures.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

class EffortTuple{
    int effort;
    int row;
    int col;
    EffortTuple(int effort, int row, int col){
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}
class PathWithMinimumEffort {
    
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<EffortTuple> priorityQueue = new PriorityQueue<>((a,b)->a.effort - b.effort);

        int row = heights.length;
        int col = heights[0].length;

        int[][] dist = new int[row][col];

        for(int i=0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0 ;

        priorityQueue.add(new EffortTuple(0,0,0));

        while( !priorityQueue.isEmpty() ){
            EffortTuple topEl = priorityQueue.poll();
            int effort = topEl.effort;
            int i = topEl.row;
            int j = topEl.col;

            if( i == row-1 && j == col-1)   return effort;

            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

            for(int[] direction : directions ){
                int newRow = i + direction[0];
                int newCol = j + direction[1];

                if( newRow < 0 || newCol < 0 || newRow > row-1 || newCol > col-1)   continue;

                int currEffort = Math.abs( heights[i][j] - heights[newRow][newCol] );
                int newEffort = Math.max(currEffort, effort);
                if( newEffort < dist[newRow][newCol] ){
                    priorityQueue.add( new EffortTuple( newEffort, newRow, newCol));
                    dist[newRow][newCol] = newEffort;
                }

            }
        }
        return -1;
    }
}