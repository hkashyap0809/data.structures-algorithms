package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left=null;
		right=null;
	}
}

//GFG
public class LevelOrderSpiral {
	ArrayList<Integer> findSpiral(Node root) {

		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<Node>();
		boolean leftToRight = false;

		queue.add(root);

		while( !queue.isEmpty() ) {
			int queueSize = queue.size();
			ArrayList<Integer> ds = new ArrayList<Integer>();
			for(int i = 1; i<=queueSize; i++ ) {
				Node topEl = queue.poll();
				ds.add(topEl.data);
				if ( topEl.left != null)				queue.add(topEl.left);
				if ( topEl.right != null)				queue.add(topEl.right);
			}
			if ( leftToRight ) {
				for( Integer num : ds ) {
					result.add(num);
				}
			}else {
				for(int i=ds.size()-1;i>=0;i--) {
					result.add(ds.get(i));
				}
			}
			leftToRight = !leftToRight;
		}
		return result;
	}

	//LEETCODE
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if(root == null )   return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;

		while( !queue.isEmpty() ){
			int queueSize = queue.size();

			List<Integer> levelList = new ArrayList<>();
			for(int i=0;i<queueSize;i++){
				TreeNode topEl = queue.poll();
				if( topEl != null) levelList.add(topEl.val);

				if( topEl != null && topEl.left != null )    queue.add(topEl.left);
				if( topEl != null && topEl.right != null )    queue.add(topEl.right);
			}
			if( level%2 == 0 )  result.add(levelList);
			else{
				Collections.reverse(levelList);
				result.add(levelList);
			}
			level++;
		}
		return result;
	}


}

