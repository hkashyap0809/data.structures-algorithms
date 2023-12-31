package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String,Integer> hashMap = new HashMap<>();
		DisjointSet disjointSet = new DisjointSet(accounts.size());

		for(int i=0; i<accounts.size(); i++ ){
			List<String> entry = accounts.get(i);
			result.add( new ArrayList<>());
			for(int j = 1; j < entry.size(); j++ ){
				String email = entry.get(j);
				if ( hashMap.containsKey( email )){
					disjointSet.unionByRank(hashMap.get(email) , i );

				}else{
					hashMap.put(email,i);
				}
			}
		}

		for( Map.Entry<String,Integer> entry : hashMap.entrySet() ){
			String email = entry.getKey();
			int idx = entry.getValue();

			int parent = disjointSet.findParent(idx);
			result.get(parent).add(email);
		}

		List<List<String>> finalResult = new ArrayList<>();
		for(List<String> res : result ){
			if ( res.size() == 0 )	continue;
			Collections.sort(res);
			int parent = hashMap.get(res.get(0));
			parent = disjointSet.parent[parent];

			List<String> ds = new ArrayList<>();
			ds.add(accounts.get(parent).get(0));
			for( String email : res ){
				ds.add(email);
			}
			finalResult.add(ds);
		}
		return finalResult;
	}

}
