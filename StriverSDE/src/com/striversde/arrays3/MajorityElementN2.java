package com.striversde.arrays3;
import java.util.*;
public class MajorityElementN2 {
	public int majorityElementBetter(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) +1 );
			}else{
				map.put(nums[i],1);
			}
		}
		int maxElem = 0;
		int maxFreq = 0;
		for(Map.Entry<Integer,Integer> it : map.entrySet()){
			int key = it.getKey();
			int val = it.getValue();
			if(val > maxFreq){
				maxElem = key;
				maxFreq = val;
			}
		}
		return maxElem;
	}
	public int majorityElement(int[] nums){
		int element=nums[0];
		int count = 0;
		for(int num : nums){
			if( count == 0 ){
				element = num;
				count++;
			}else if( num != element){
				count--;
			}else if ( num == element){
				count++;
			}
		}
		//check if majority element is not present
		int finalCount = 0;
		for( int num : nums ){
			if ( num == element ){
				finalCount++;
			}
		}
		if ( finalCount > nums.length/2)    return element;
		return -1;
	}
}
