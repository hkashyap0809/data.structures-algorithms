package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class NodePair{
	Node node;
	int vertical;
	NodePair(Node node, int vertical){
		this.node = node;
		this.vertical = vertical;
	}
}

public class TopViewBinaryTree {
	static ArrayList<Integer> topView(Node root)
	{
		Queue<NodePair> queue = new LinkedList<>();
		queue.add( new NodePair(root,0));

		TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		while( !queue.isEmpty() ){
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++){
				NodePair topEl = queue.poll();
				Node node = topEl.node;
				int vertical = topEl.vertical;

				if( node.left != null ) queue.add( new NodePair(node.left,vertical-1));
				if( node.right != null ) queue.add( new NodePair(node.right,vertical+1));

				if( !treeMap.containsKey(vertical) ){
					treeMap.put(vertical,node.data);
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
			result.add(entry.getValue());
		}
		return result;

	}

}
