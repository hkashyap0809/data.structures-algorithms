package com.a2zdsa.binaryTrees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public List<Integer> rightSideViewLevel(TreeNode root) {

		if( root == null )  return new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<Integer> rightView = new ArrayList<>();


		while( !queue.isEmpty() ){
			int queueSize = queue.size();
			int rightVal = -200;
			for(int i = 0; i< queueSize; i++ ){
				TreeNode topEl = queue.poll();

				if( topEl != null && topEl.right != null)
					queue.add(topEl.right);

				if( topEl != null && topEl.left != null)
					queue.add(topEl.left);

				if( rightVal == -200){
					rightVal = topEl.val;
				}
			}
			rightView.add(rightVal);
		}
		return rightView;
	}

	public List<Integer> rightSideViewRecursion(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		getRightSideViewRecursionHelper(root,0,result);
		return result;


	}

	private void getRightSideViewRecursionHelper(TreeNode root, int level, List<Integer> result) {
		if ( root == null )	return;
		if ( level == result.size() )	result.add(root.val);

		getRightSideViewRecursionHelper(root.right, level+1, result);
		getRightSideViewRecursionHelper(root.left, level+1, result);

	}


}
