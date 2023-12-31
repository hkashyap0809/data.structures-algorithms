package com.datastructures.sorting;

public class SortAnArray {

	public static void sortArray(int[] nums ) {
		sortArray(nums, nums.length-1);
	}

	public static void sortArray(int[] nums, int idx ) {
		if ( idx == 0 )	return ;

		int elem = nums[idx];
		sortArray(nums,idx-1);
		insertInArray(nums, idx, elem);
	}

	public static void insertInArray(int[] nums, int idx, int elem) {

		if ( idx == 0 )	{
			nums[idx] = elem;
			return;
		}

		if( nums[idx-1] <= elem ) {
			nums[idx] = elem;
		}else {
			int elem1 = nums[idx-1];
			insertInArray(nums,idx-1,elem);
			nums[idx] = elem1;
		}
	}


	public static void main(String[] args) {
//		int[] arr = { 9,8,7,6,5,4,3,2,1 };
		int[] arr = {3,5,2,7,3,7,2,5,4,8,9,1,6};
		sortArray(arr);
		for(int num : arr ) {
			System.out.print(num+" ");;
		}
	}

}
