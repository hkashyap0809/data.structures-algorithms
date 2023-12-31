package com.datastructures.binarysearch;

public class SingleElementInSortedArray {
	
	public int singleNonDuplicateXOR(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while ( low <= high ){
            int mid = (low+high)/2;
            if ( nums[mid] == nums[mid^1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low];
    }
	
	public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while ( low <= high ){
            int mid = (low+high)/2;
            
             if ( mid%2 == 1 ){
                 if ( nums[mid] == nums[mid-1]){
                     low = mid + 1;
                 }else{
                     high = mid - 1;
                 }
             }else{
                 if ( nums[mid]==nums[mid+1] ){
                     low = mid + 1;
                 }else{
                     high = mid -1;
                 }
             }
        }
        return nums[low];
    }

}
