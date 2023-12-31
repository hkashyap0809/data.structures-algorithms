package com.datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

class Tuple{
	int sum;
	int idx1;
	int idx2;
	Tuple(int sum, int idx1, int idx2){
		this.sum = sum;
		this.idx1 = idx1;
		this.idx2 = idx2;
	}
}
public class MaximumSumCombination {
	public static String stringEquivalent(int idx1, int idx2){
		return Integer.toString(idx1)+"-"+Integer.toString(idx2);
	}

	public ArrayList<Integer> solve(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int K) {
		Collections.sort(nums1);
		Collections.sort(nums2);
		int N = nums1.size();

		PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->b.sum - a.sum);
		HashSet<String> hashSet = new HashSet<>();

		pq.add(new Tuple(nums1.get(N-1)+nums2.get(N-1),N-1,N-1));
		hashSet.add(stringEquivalent(N-1,N-1));
		ArrayList<Integer> result = new ArrayList<>();

		while( K > 0){
			K--;
			Tuple topEl = pq.poll();
			int sum = topEl.sum;
			int idx1 = topEl.idx1;
			int idx2 = topEl.idx2;
			result.add(sum);

			if ( idx1 > 0 && idx2 > 0 && !hashSet.contains(stringEquivalent(idx1-1,idx2))){
				pq.add(new Tuple( nums1.get(idx1-1)+nums2.get(idx2),idx1-1, idx2 ));
				hashSet.add(stringEquivalent(idx1-1, idx2));
			}

			if ( idx1 > 0 && idx2 > 0 && !hashSet.contains(stringEquivalent(idx1,idx2-1))){
				pq.add(new Tuple( nums1.get(idx1)+nums2.get(idx2-1),idx1, idx2-1 ));
				hashSet.add(stringEquivalent(idx1, idx2-1));

			}

		}
		return result;
	}

	//using Inbuilt Pair

	//	public ArrayList<Integer> solve(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int K) {
	//        Collections.sort(nums1);
	//        Collections.sort(nums2);
	//        int N = nums1.size();
	//        
	//        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> pq = new PriorityQueue<>((a,b)->b.getKey() - a.getKey());
	//        HashSet<Pair<Integer,Integer>> hashSet = new HashSet<>();
	//        
	//        pq.add(new Pair(nums1.get(N-1)+nums2.get(N-1),newPair(N-1,N-1)));
	//        hashSet.add(new Pair(N-1,N-1));
	//        List<Integer> result = new ArrayList<>();
	//        
	//        while( K > 0){
	//            K--;
	//            Tuple topEl = pq.poll();
	//            int sum = topEl.getKey();
	//            int idx1 = topEl.getValue().getKey();
	//            int idx2 = topEl.getValue().getValue();
	//            result.add(sum);
	//            
	//            if ( idx1 > 0 && idx2 > 0 && !hashSet.contains(stringEquivalent(idx1-1,idx2))){
	//                pq.add( new Pair(nums1.get(idx1-1)+nums2.get(idx2)) , new Pair(idx1-1,idx2)) ;
	//                hashSet.add( new Pair( idx1-1, idx2 ));
	//            }
	//            
	//            if ( idx1 > 0 && idx2 > 0 && !hashSet.contains(stringEquivalent(idx1,idx2-1))){
	//                pq.add( new Pair(nums1.get(idx1)+nums2.get(idx2-1)) , new Pair(idx1,idx2-1));
	//                hashSet.add( new Pair(idx1, idx2-1));
	//            }
	//            
	//        }
	//        return result;
	//    }
}
