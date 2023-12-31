package com.datastructures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationToReachEnd {
	static class MinStepPair{
		int steps;
		int node;
		MinStepPair(int steps, int node){
			this.steps = steps;
			this.node = node;
		}
	}
	int minimumMultiplications(int[] arr, int start, int end) {

		if ( start == end ) return 0;
		Queue<MinStepPair> queue = new LinkedList<>();
		queue.add(new MinStepPair(0,start));
		int[] step = new int[100000];
		Arrays.fill(step,Integer.MAX_VALUE);

		while( !queue.isEmpty() ){
			MinStepPair topEl = queue.poll();
			for(int num : arr ){
				int newSteps = topEl.steps + 1;
				int newNode = (topEl.node * num)%100000;
				if ( newNode == end )   return newSteps;

				if( newSteps < step[newNode] ){
					queue.add( new MinStepPair(newSteps,newNode));
					step[newNode] = newSteps;
				}
			}
		}
		return -1;
	}

}
