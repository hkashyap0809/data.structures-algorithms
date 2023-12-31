package com.striversde.arrays2;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
	//Brute
	public int[][] mergeBrute(int[][] intervals) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Arrays.sort(intervals,(a,b) -> a[0] - b[0] );

		for(int i=0; i<intervals.length;i++){
			int start = intervals[i][0];
			int end = intervals[i][1];
			if ( ans.size() > 0 && start <= ans.get(ans.size()-1).get(1) )
				continue;
			for(int j = i+1; j<intervals.length; j++ ){
				int currStart = intervals[j][0];
				int currEnd = intervals[j][1];
				if ( currStart>= start && currStart<= end)
					end = Math.max( currEnd,end);
				else
					break;
			}
			ArrayList<Integer> ds = new ArrayList<>();
			ds.add(start);
			ds.add(end);
			ans.add(ds);
		}

		int[][] ansNew = new int[ans.size()][2];
		int i = 0;
		for(ArrayList<Integer> interval : ans ){
			ansNew[i][0] = interval.get(0);
			ansNew[i][1] = interval.get(1);
			i++;
		}
		return ansNew;
	}

	//Optimal
	public int[][] mergeOptimal(int[][] intervals) {

		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();


		for(int i = 0; i < intervals.length; i++ ){

			if ( ans.size() == 0 || intervals[i][0] > ans.get(ans.size()-1).get(1)  ){
				ArrayList<Integer> ds = new ArrayList<>();
				ds.add(intervals[i][0]);
				ds.add(intervals[i][1]);
				ans.add(ds);
			}else{
				int newEnd = Math.max ( intervals[i][1], ans.get(ans.size()-1).get(1));
				ans.get(ans.size()-1).set(1,newEnd);
			}
		}
		int[][] finalAns = new int[ans.size()][2];
		int i=0;
		for(ArrayList<Integer> list : ans){
			finalAns[i][0] = list.get(0);
			finalAns[i][1] = list.get(1);
			i++;
		}
		return finalAns;
	}
}
