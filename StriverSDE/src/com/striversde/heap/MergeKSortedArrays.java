package com.striversde.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class MergePairArray{
	int num;
	int list;
	int idx;
	MergePairArray(int num, int list, int idx){
		this.num = num;
		this.list = list;
		this.idx = idx;
	}
}
public class MergeKSortedArrays {
	//Function to merge k sorted arrays.
	public static ArrayList<Integer> mergeKArrays(int[][] arr,int K){
		PriorityQueue<MergePairArray> pq = new PriorityQueue<>((a,b)-> a.num - b.num );

		for(int i=0; i<K; i++){
			if ( arr[i].length > 0 )
				pq.add(new MergePairArray(arr[i][0],i,0));
		}

		ArrayList<Integer> mergedList = new ArrayList<>();

		while( !pq.isEmpty() ){

			MergePairArray topEl = pq.poll();
			int num = topEl.num;
			int list = topEl.list;
			int idx = topEl.idx;

			mergedList.add(num);

			if ( idx+1 <= arr[list].length-1 ){
				pq.add( new MergePairArray(arr[list][idx+1],list,idx+1));
			}

		}
		return mergedList;

	}
}
