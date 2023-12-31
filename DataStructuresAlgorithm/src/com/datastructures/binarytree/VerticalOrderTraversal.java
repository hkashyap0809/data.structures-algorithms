package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TriNode {
	TreeNode node;
	int vertical;
	int level;
	TriNode(TreeNode node, int vertical, int level){
		this.node = node;
		this.vertical = vertical;
		this.level = level;
	}
}


public class VerticalOrderTraversal {

	//Inorder Traversal
	public void inorderTraversal(TreeNode root, int vertical, int level, TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> treeMap){
		if( root == null )  return;

		inorderTraversal(root.left,vertical-1,level+1,treeMap);
		if( !treeMap.containsKey(vertical)){
			treeMap.put(vertical,new TreeMap<Integer,ArrayList<Integer>>());
		}

		if( !treeMap.get(vertical).containsKey(level)){
			treeMap.get(vertical).put(level, new ArrayList<Integer>());
		}

		treeMap.get(vertical).get(level).add(root.val);
		inorderTraversal(root.right,vertical+1,level+1,treeMap);
	}


	public List<List<Integer>> verticalTraversalInorder(TreeNode root) {

		TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> treeMap = new TreeMap<>();
		inorderTraversal(root,0,0,treeMap);

		List<List<Integer>> result = new ArrayList<>();
		for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> entry : treeMap.entrySet()){
			ArrayList<Integer> list = new ArrayList<>();
			for(Map.Entry<Integer,ArrayList<Integer>> entry2 : entry.getValue().entrySet()){
				Collections.sort(entry2.getValue());
				list.addAll( entry2.getValue());
			}
			result.add(list);
		}
		return result;
	}

	//Level Order Traversal
	public List<List<Integer>> verticalTraversalLevel(TreeNode root) {
		Queue<TriNode> queue = new LinkedList<>();    
		queue.add( new TriNode(root,0,0));
		TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> treeMap = new TreeMap<>();

		while( !queue.isEmpty() ){
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++){
				TriNode topEl = queue.poll();
				TreeNode node = topEl.node;
				int vertical = topEl.vertical;
				int level = topEl.level;

				if( node.left != null ) queue.add( new TriNode(node.left,vertical-1,level+1));
				if( node.right != null ) queue.add( new TriNode(node.right,vertical+1,level+1));

				if( !treeMap.containsKey(vertical)){
					treeMap.put(vertical,new TreeMap<Integer,ArrayList<Integer>>());
				}

				if( !treeMap.get(vertical).containsKey(level)){
					treeMap.get(vertical).put(level, new ArrayList<Integer>());
				}
				treeMap.get(vertical).get(level).add(node.val);
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> entry : treeMap.entrySet()){
			ArrayList<Integer> list = new ArrayList<>();
			for(Map.Entry<Integer,ArrayList<Integer>> entry2 : entry.getValue().entrySet()){
				Collections.sort(entry2.getValue());
				list.addAll( entry2.getValue());
			}
			result.add(list);
		}
		return result;


	}
}
