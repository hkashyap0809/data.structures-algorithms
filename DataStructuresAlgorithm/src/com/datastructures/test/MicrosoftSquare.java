package com.datastructures.test;

import java.util.Arrays;
import java.util.TreeMap;

public class MicrosoftSquare {
	
	static class HelperObject{
		boolean result;
		int start;
		int end;
		HelperObject(boolean result, int start, int end){
			this.result = result;
			this.start = start;
			this.end = end;
		}
	}
	
		
	static HelperObject subsetSum(int[] subset, int sum, int start, int end) {
		System.out.println("sum "+sum+ " start "+start+" end "+end);
		
		if( start > end )	return new HelperObject(false, start, end);
		
		if( sum == subset[end] )
			return new HelperObject(true,start,end-1);
		
		while( start <= end ) {
			int currSum = subset[start] + subset[end];
			
			if( currSum == sum ) {
				return new HelperObject(true,start+1,end-1);
			}else if( sum > currSum ) {
				sum = sum - subset[end];
				end--;
			}else {
				start++;
			}
		}
		return new HelperObject(false,start,end);
	}
	static boolean canWeMake(int[] edges, int edge) {
		
		System.out.println("can we make square of edge " +edge);
		
		int i = 0;
		int j = edges.length-1;
		
		boolean edge1=false,edge2=false,edge3=false,edge4=false;
		
		HelperObject result1 = subsetSum(edges, edge, i, j); 
		edge1 = result1.result; 
		if( edge1 == false )	return false;
		
		i = result1.start;
		j = result1.end; 
		
		HelperObject result2 = subsetSum(edges,edge,i,j);
		edge2 = result2.result; 
		if( edge2 == false )	return false;
		
		i = result2.start;
		j = result2.end; 
		
		HelperObject result3 = subsetSum(edges,edge,i,j);
		edge3 = result3.result; 
		if( edge3 == false )	return false;
		
		i = result3.start;
		j = result3.end; 
		
		HelperObject result4 = subsetSum(edges,edge,i,j);
		edge4 = result4.result; 
		if( edge4 == false )	return false;
		 
		
		return true;
		
	}
	static int solution(int[] edges) {
		
		Arrays.sort(edges);
		int sumEdges = 0;
		for( int edge : edges) {
			System.out.print(edge +" ");
			sumEdges = sumEdges + edge;
		}
		System.out.println();
		
		int low = 1;
		int high = sumEdges/4;
		
		for( int i = high; i>= low; i--) {
			boolean squarePossible = canWeMake(edges, i);
			System.out.println("squarePossible " +squarePossible+" i "+i);
			if( squarePossible ) return i;
			
		}
		return -1;
	}
	public static void main(String[] args) {
//		int[] A = {3,3,3,2,1,1}; //3
//		int[] A = {10,10,10,2,2,2,2,2}; //10
		int[] A = {2,3,5,1,1,6,3,5};
		System.out.println(solution(A));
	}

}
