package com.datastructures.greedy;

import java.util.Arrays;

public class MinimumPlatforms {
	public static int findPlatform(int arr[], int dep[], int n){
		Arrays.sort(arr);
		Arrays.sort(dep);

		int i = 1;
		int j = 0;
		int currPlatformRequired = 1;
		int maxPlatformsRequired = 1;

		while( i < n && j < n ){
			if ( arr[i] <= dep[j] ){
				//when arrival and departure of two diff trains are greater or same
				// arr[i] == dep[j] also requires another platform
				currPlatformRequired++;
				maxPlatformsRequired = Math.max( maxPlatformsRequired, currPlatformRequired);
				i++;
			}else if( arr[i] > dep[j]) {
				// when a train departs before the arrival of any other train 
				//one platform is empty
				currPlatformRequired--;
				j++;
			}
		}

		return maxPlatformsRequired;
	}

}
