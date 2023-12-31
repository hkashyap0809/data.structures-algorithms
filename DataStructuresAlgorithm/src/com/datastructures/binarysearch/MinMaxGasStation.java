package com.datastructures.binarysearch;

import java.util.Arrays;
import java.util.PriorityQueue;

class GasPair{
	double dist;
	int idx;
	GasPair(double dist, int idx){
		this.dist = dist;
		this.idx = idx;
	}
}


public class MinMaxGasStation {

	//Brute Force
	public static double MinimiseMaxDistanceBrute(int []arr, int k){
		int[] gasStationPlaced = new int[arr.length-1];

		for(int gasStation = 1; gasStation <=k; gasStation++) {
			double maxSectorVal = -1;
			int maxSectorIndex = -1;
			for(int i=0; i<arr.length-1; i++) {
				int diff = arr[i+1] - arr[i];
				double sectorLength = (double) diff / (double)(gasStationPlaced[i]+1);

				if( sectorLength > maxSectorVal ) {
					maxSectorVal = sectorLength;
					maxSectorIndex = i;
				}
			}
			gasStationPlaced[maxSectorIndex]++;
		}

		double maxDist = -1.0;
		for(int i=0;i < arr.length-1; i++) {

			int diff = arr[i+1] - arr[i];
			double sectorLength = (double)diff/(double)(gasStationPlaced[i]+1);
			maxDist = Math.max(sectorLength, maxDist);
		}
		return maxDist;
	}

	//Better - PriorityQueue
	public static double findSmallestMaxDistBetter(int arr[],int k) {
		int[] gasStationPlaced = new int[arr.length-1];
		Arrays.fill(gasStationPlaced,0);
		PriorityQueue<GasPair> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

		for(int i=0;i<arr.length-1;i++)	priorityQueue.add( new GasPair(arr[i+1]-arr[i], i));

		for(int gasStation = 1; gasStation <=k; gasStation++) {

			GasPair topEl = priorityQueue.poll();
			int idx = topEl.idx;
			gasStationPlaced[idx]++;
			double diff = arr[idx+1] - arr[idx];
			double newSecLen =  diff / (double)(gasStationPlaced[idx]+1);
			priorityQueue.add(new GasPair(newSecLen,idx));
		}
		return priorityQueue.peek().dist;
	}

	//Optimal - Binary Search
	public static double findSmallestMaxDist(int arr[],int k) {
		double low = 0;
		double high = 0;
		for(int i=0;i<arr.length-1;i++) {
			high = Math.max(high, arr[i+1] - arr[i]);
		}

		while( high - low > 1e-6) {
			double mid = (low+high)/2.0;
			int gasStationPlaced = placeGasStation(mid,arr);
			if( gasStationPlaced > k ) {
				low = mid;
			}else {
				high = mid;
			}
		}
		return high;
	}

	private static int placeGasStation(double dist, int[] arr) {
		int gasStationCount=0;
		for(int i=0;i<arr.length-1;i++) {
			double gasPlaced = Math.ceil( (arr[i+1]-arr[i])/dist);
			gasStationCount+=gasPlaced-1;
		}
		return gasStationCount;
	}

}
