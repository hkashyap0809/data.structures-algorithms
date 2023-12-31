package com.a2zdsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrayFindUnion {
	public static List< Integer > sortedArray(int []a, int []b) {

		List<Integer> result  = new ArrayList<>();
		int len1 = a.length;
		int len2 = b.length;

		int i = 0;
		int j = 0;
		int lastnum =0;

		if( a[i] < b[j]){
			lastnum = a[i];
			result.add(a[i]);
			i++;
		}else if( a[i] > b[j] ){
			lastnum = b[j];
			result.add(b[j]);
			j++;
		}else{
			lastnum = a[i];
			result.add(a[i]);
			i++;
			j++;
		}
		while( i< len1 && j < len2 ){

			if( a[i] < b[j] ){
				if( a[i]!=lastnum ){
					lastnum=a[i];
					result.add(a[i]);
				}
				i++;
			}else if( a[i] > b[j] ){
				if( b[j]!=lastnum ){
					lastnum=b[j];
					result.add(b[j]);
				}
				j++;
			}else if( a[i] == b[j] ){
				if( a[i]!=lastnum ){
					lastnum=a[i];
					result.add(a[i]);
				}
				i++;
				j++;
			}
		}
		while( i < len1 ){
			if( lastnum != a[i] ){
				result.add(a[i]);
				lastnum = a[i];
			}
			i++;
		}

		while( j < len2 ){
			if( lastnum != b[j] ){
				result.add( b[j]);
				lastnum = b[j];
			}
			j++;
		}
		return result;
	}

}
