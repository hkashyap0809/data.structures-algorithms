package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTree {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<List<Integer>> levelOrder = new ArrayList<>();
		if( root == null )	return levelOrder;
		while( !queue.isEmpty() ) {
			int queueSize = queue.size();
			List<Integer> level = new ArrayList<>();
			for(int i=0;i<queueSize;i++) {
				TreeNode elem = queue.poll();
				if( elem !=null && elem.left != null ) {
					queue.add(elem.left);
				}
				if( elem != null && elem.right != null ) {
					queue.add(elem.right);
				}
				if(elem != null )
					level.add(elem.val);
			}
			levelOrder.add(level);
		}
		return levelOrder;
	}

}
