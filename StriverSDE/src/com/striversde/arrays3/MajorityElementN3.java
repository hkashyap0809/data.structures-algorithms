package com.striversde.arrays3;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class MajorityElementN3 {
	public List<Integer> majorityElement(int[] nums) {

		int elem1 = nums[0];
		int elem2 = nums[0];
		int count1 = 0;
		int count2 = 0;

		for( int num : nums ) {
			if( count1 == 0 && num!=elem2) {
				elem1 = num;
				count1++;
			}else if( count2 == 0 && num!=elem1) {
				elem2 = num;
				count2++;
			}
			else if( num == elem1 ) {
				count1++;
			}else if( num == elem2 ) {
				count2++;
			}else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for(int num : nums){
			if ( num == elem1 )  count1++;
			if ( num == elem2 )    count2++;
		}
		List<Integer> ds = new ArrayList<>();
		if ( count1 > nums.length/3 )
			ds.add(elem1);
		if( count2 > nums.length/3 && elem1!=elem2)
			ds.add(elem2);  
		Collections.sort(ds);
		return ds;

	}

}
