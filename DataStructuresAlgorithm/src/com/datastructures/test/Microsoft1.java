package com.datastructures.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int solution(String s, int[] C) {
		Map<Character, List<Integer>> hashMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!hashMap.containsKey(ch))
				hashMap.put(ch, new ArrayList<>());
			hashMap.get(ch).add(i);
		}

		List<List<Integer>> lines = new ArrayList<>();
		for (Map.Entry<Character, List<Integer>> e : hashMap.entrySet()) {
			List<Integer> list = e.getValue();
			for (int i = 0; i < list.size() - 1; i++) {
				int start = list.get(i);
				int end = list.get(i + 1);
				lines.add(List.of(start, end));
			}
		}

		if (lines.size() == 0)
			return 0;

		int n = lines.size();

		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int count = findCount(mid, lines, C);
			if (count == n)
				high = mid - 1;
			else if (count == -1)
				low = mid + 1;
		}

		return findCount(high + 1, lines, C);

	}

	private int findCount(int x, List<List<Integer>> lines, int C[]) {
		int c = C[x];
		int count = 0;
		for (int i = 0; i < lines.size(); i++) {
			int start = lines.get(i).get(0);
			int end = lines.get(i).get(1);

			if (start < c && c <= end) {
				count++;
			}

			if (count == lines.size())
				return x + 1;
		}
		return -1;
	}
}


class Solution
{
	public int solution(String s, int[] C)
	{
		// Implement your solution
		Map<Character, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			map.putIfAbsent(ch, new ArrayList<>());
			map.get(ch).add(i);
		}

		List<int[]> segments = new ArrayList<>();
		for (var e : map.entrySet())
		{
			var list = e.getValue();
			for (int i = 0; i < list.size() - 1; i++)
			{
				int start = list.get(i);
				int end = list.get(i + 1);
				segments.add(new int[] { start, end });
			}
		}

		if (segments.size() == 0)
			return 0;

		int n = segments.size();
		
		int low = 0, high = n - 1;
		while(low <= high)
		{
			int mid = (low + high) / 2;
			int count = helper(mid, segments, C);
			if(count == n)
				high = mid - 1;
			else if(count == -1)
				low = mid + 1;
		}

		return helper(high + 1, segments, C);

	}
	
	private int helper(int x, List<int[]> segments, int C[])
	{
		int c = C[x];
		int count = 0;
		for (int i = 0; i < segments.size(); i++)
		{
			int start = segments.get(i)[0];
			int end = segments.get(i)[1];

			if (start < c && c <= end)
			{
				count++;
			}

			if (count == segments.size())
				return x + 1;
		}
		return -1;
		
	}

}