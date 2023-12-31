package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
}

class TreePair{
	int node;
	int dist;
	TreePair(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
	
	
}
public class AllNodes {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
		createGraph(root,adjList);
		
				
		for( Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet()) {
			System.out.println(entry.getKey()+ " "+ entry.getValue().toString());
		}
		
		int src = target.val;
		
		
//		startBFS(src,adjList,k,result);
		
		HashMap<Integer,Boolean> visited = new HashMap<>();
		startDFS(src,adjList,k,result,visited);
		
		return result;
	}



	private void startDFS(int src, HashMap<Integer, ArrayList<Integer>> adjList, int k, List<Integer> result,
			HashMap<Integer, Boolean> visited) {
		
		visited.put(src, true);
		
		if ( k == 0 ) {
			result.add(src);
			return;
		}
		
		if ( adjList.get(src) == null ) return;
		
		for( Integer neighbour : adjList.get(src) ) {
			if ( !visited.get(neighbour) ) 
				startDFS(neighbour,adjList,k-1,result,visited);
			
		}
		
	}



private void startBFS(int src, HashMap<Integer, ArrayList<Integer>> adjList, int k, List<Integer> result) {
		
		Queue<TreePair> queue = new LinkedList<TreePair>();
		HashMap<Integer,Boolean> visited = new HashMap<>();
		queue.add(new TreePair(src,0));
		visited.put(src, true);
		
		while( !queue.isEmpty() ) {
			TreePair topEl = queue.poll();
			int node = topEl.node;
			int dist = topEl.dist;
			
			if ( dist == k )
				result.add(node);
			
			if ( adjList.get(node) == null )	continue;
			for(Integer neighbour : adjList.get(node)) {
				if ( visited.getOrDefault(neighbour,false) ) continue;
				queue.add( new TreePair(neighbour , dist+1));
				visited.put(neighbour, true);
				
			}		
		}
		
	}

	private void createGraph(TreeNode root, HashMap<Integer, ArrayList<Integer>> adjList) {
		
		if ( root == null ) {
			return;
		}
		if ( root.left != null ) {
			int u = root.val;
			int v = root.left.val;
			ArrayList<Integer> ds;
			if ( adjList.containsKey(u) ) {
				ds = adjList.get(u);				
			}else {
				ds = new ArrayList<Integer>();
			}
			ds.add(v);
			adjList.put(u, ds);
			
			if ( adjList.containsKey(v) ) {
				ds = adjList.get(v);				
			}else {
				ds = new ArrayList<Integer>();
			}
			ds.add(u);
			adjList.put(v, ds);
			
		}
		
		if ( root.right != null ) {
			int u = root.val;
			int v = root.right.val;
			ArrayList<Integer> ds;
			if ( adjList.containsKey(u) ) {
				ds = adjList.get(u);				
			}else {
				ds = new ArrayList<Integer>();
			}
			ds.add(v);
			adjList.put(u, ds);
			
			if ( adjList.containsKey(v) ) {
				ds = adjList.get(v);				
			}else {
				ds = new ArrayList<Integer>();
			}
			ds.add(u);
			adjList.put(v, ds);
			
		}
		createGraph(root.left, adjList);
		createGraph(root.right,adjList);		
	}





}
