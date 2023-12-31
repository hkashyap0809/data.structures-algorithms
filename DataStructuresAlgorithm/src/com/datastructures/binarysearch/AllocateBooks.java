package com.datastructures.binarysearch;

import java.util.ArrayList;

public class AllocateBooks {
	public static int findPages(ArrayList<Integer> arr, int n, int m) {
		if ( arr.size() < m )   return -1;
		int low = arr.get(0);
		int high = 0;
		for(Integer num : arr ){
			low = Math.max(num,low);
			high = high + num;
		}

		return binarySearch(low,high,arr,m);
	}
	public static int binarySearch(int low, int high, ArrayList<Integer> arr, int m){
		int ans = low;
		while ( low <= high ){
			int mid = (low + high )/2;
			int allotedStudents = canWeAllocate(arr, mid);
			if (allotedStudents > m ) {
				low = mid + 1;
				ans = low;
			}else{
				high = mid - 1 ;
			}
		}
		return ans;
	}

	public static int canWeAllocate(ArrayList<Integer> arr, int maxPages){
		int studentsAllocated = 1;
		int booksToLastStudent = arr.get(0);
		for(int i=1; i<arr.size();i++){
			if ( booksToLastStudent + arr.get(i) > maxPages ){
				studentsAllocated++;
				booksToLastStudent = arr.get(i);
			}else{
				booksToLastStudent = booksToLastStudent + arr.get(i);
			}
		}
		return studentsAllocated;
	}

}
