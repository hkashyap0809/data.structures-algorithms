package com.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class TreeWidthPair{
	TreeNode node;
	int level;

	TreeWidthPair(TreeNode node, int level){
		this.node = node;
		this.level = level;
	}
}

public class MaxWidthBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if( root == null )return 0;

		Queue<TreeWidthPair> queue = new LinkedList<>();
		queue.add(new TreeWidthPair(root, 0));
		int maxWidth = Integer.MIN_VALUE;

		while( !queue.isEmpty() ) {
			int queueSize = queue.size();

			int firstIndex = -1;
			int lastIndex = -1;
			int min = queue.peek().level;
			for(int i=1;i<=queueSize; i++) {
				TreeWidthPair topEl = queue.poll();
				TreeNode node = topEl.node;
				int level = topEl.level;
				if( i == 1)	firstIndex = level;
				if(i == queueSize ) lastIndex = level;
				// min = Math.min(level, min);
				if( node.left != null ) {
					queue.add(new TreeWidthPair(node.left, 2*(level-min)+1));
				}
				if( node.right != null ) {
					queue.add(new TreeWidthPair(node.right, 2*(level-min)+2));
				}

			}
			maxWidth = Math.max(maxWidth, lastIndex-firstIndex+1);
		}

		return maxWidth;
	}

}
